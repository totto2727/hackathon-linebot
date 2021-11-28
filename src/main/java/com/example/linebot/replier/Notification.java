package com.example.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class Notification extends Reply<MessageEvent<TextMessageContent>> {
    public Notification(MessageEvent<TextMessageContent> event) {
        super(event);
    }

    @Override
    public Message reply() {
        var message = new TextMessage("食料\n予備電池\n使い捨てカイロ\n\nの消費期限が切れてるよ！");
        return message;
    }
}
