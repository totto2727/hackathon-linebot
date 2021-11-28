package com.example.linebot;

import com.example.linebot.replier.*;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@LineMessageHandler
public class Callback {
    public static final Logger log = LoggerFactory.getLogger(Callback.class);

    @EventMapping
    public Message handleFollow(FollowEvent event) {
        var follow = new Follow(event);
        return follow.reply();
    }

    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) {
        var tmc = event.getMessage();
        var text = tmc.getText();
        if (text.matches("[a-zA-Z0-9]{28}"))
            return new SetUid(event).reply();
        if (text.equals("連携情報"))
            return new GetUid(event).reply();
        if (text.equals("lineid"))
            return new GetLineId(event).reply();
        if (text.equals("期限切れ"))
            return new Notification(event).reply();
        if (text.equals("期限一覧"))
            return new AllTerm(event).reply();
        if (text.equals("必要なもの"))
            return new Required(event).reply();
        return new TextMessage(
                "連携情報: 連携中のUIDを表示\n");
    }
}
