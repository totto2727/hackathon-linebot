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
        return new TextMessage("水 2022/11/28\n食料 2022/11/28\n予備電池 2022/11/28\n使い捨てカイロ 2022/11/28\n\nに期限が切れるよ!");
    }

}
