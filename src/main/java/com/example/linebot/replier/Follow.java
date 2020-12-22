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
        var text = String.format("あなたのユーザーID:%s", userId);
        return new TextMessage(text);
    }
}
