package com.example.linebot.replier;

import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class Follow implements Reply {
    private final FollowEvent event;

    public Follow(FollowEvent event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var userId = this.event.getSource().getUserId();
        var text = "連携手順\n①以下のURLから、ログインする\nhttps://timetable-2a507.web.app/\n②ログイン後サイト上部にあるUIDをコピーする\n③UIDを入力してこのBotに送信";
        return new TextMessage(text);
    }
}
