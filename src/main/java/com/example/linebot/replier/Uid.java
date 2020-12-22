package com.example.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class Uid implements Reply{
    MessageEvent event;

    public Uid(MessageEvent event) {
        this.event = event;
    }

    @Override
    public Message reply() {

        return new TextMessage("連携完了しました");
    }
}
