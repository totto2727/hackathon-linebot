package com.example.linebot;

import com.example.linebot.replier.*;
import com.example.linebot.utils.Dotws;
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
        if (text.matches("[a-zA-Z0-9]{28}")) return new SetUid(event).reply();
        if (text.equals("連携情報")) return new GetUid(event).reply();
        if (text.equals("時間割")) return new AllSubjects(event).reply();
        if (Dotws.isDotw(text)) return new DotwSubjects(event).reply();
        return new TextMessage(
                "連携情報: 連携中のUIDを表示\n" +
                        "時間割: 登録されている授業を全て表示\n" +
                        "月~金･･･各曜日の授業を全て表示"
        );//\n今日･明日･･･その日の一覧を表示\n数字･･･今日のその時間の授業を表示
    }
}
