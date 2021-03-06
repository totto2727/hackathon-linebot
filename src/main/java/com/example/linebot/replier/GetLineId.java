package com.example.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class GetLineId extends Reply<MessageEvent<TextMessageContent>> {
    public GetLineId(MessageEvent<TextMessageContent> event) {
        super(event);
    }

    @Override
    public Message reply() {
        return new TextMessage(event.getSource().getUserId());
    }
}
