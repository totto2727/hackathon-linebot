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
        var text = "連携手順\n①以下のURLから、ログインする\nhttps://timetable-2a507.web.app/\n②UIDを発行し、コピーする\n③｢連携｣と送信\n④UIDを聞かれる後、UIDを入力して送信";
        return new TextMessage(text);
    }
}
