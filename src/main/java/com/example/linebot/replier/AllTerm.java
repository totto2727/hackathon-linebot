package com.example.linebot.replier;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class AllTerm extends Reply<MessageEvent<TextMessageContent>> {

    public AllTerm(MessageEvent<TextMessageContent> event) {
        super(event);
    }

    @Override
    public Message reply() {
        return new TextMessage("期限一覧/n食べ物：2021/11/28");
    }

}
