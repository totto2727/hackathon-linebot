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
        var text = "災害に備えて準備を万端にしよう!";
        return new TextMessage(text);
    }
}
