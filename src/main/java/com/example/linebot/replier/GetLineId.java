package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GetLineId extends Reply<MessageEvent<TextMessageContent>> {
    public GetLineId(MessageEvent<TextMessageContent> event) {
        super(event);
    }

    @Override
    public Message reply() {
        return new TextMessage(event.getSource().getUserId());
    }
}
