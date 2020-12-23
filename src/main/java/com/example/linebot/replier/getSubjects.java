package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class getSubjects implements Reply{
    private final MessageEvent<TextMessageContent> event;

    public getSubjects(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var lineUid=event.getSource().getUserId();
        try {
            var data=new FirestoreService().getSubjects(lineUid);
            System.out.println(data.toString());
            return new TextMessage("データを取得しました");
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データの取得に失敗しました");
        }
    }
}
