package com.example.linebot.replier;

import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class Follow extends Reply<FollowEvent> {
    public Follow(FollowEvent event) {
        super(event);
    }

    @Override
    public Message reply() {
        var text = "連携手順\n" +
                "①以下のURLから、ログインする\n" +
                "https://timetable-2a507.web.app/\n" +
                "②ログイン後サイト上部にあるUIDをコピーする\n" +
                "③UIDを入力してこのBotに送信";
        return new TextMessage(text);
    }
}
