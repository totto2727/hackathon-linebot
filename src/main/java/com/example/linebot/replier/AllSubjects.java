package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class AllSubjects implements Reply{
    private final MessageEvent<TextMessageContent> event;

    public AllSubjects(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var lineUid=event.getSource().getUserId();
        try {
            var data=new FirestoreService().getSubjects(lineUid);
            //var subjects=
            data.values()
                    .stream()
                    .filter(k->k instanceof Map)
                    .forEach(System.out::println);
            return new TextMessage("データを取得しました");
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データの取得に失敗しました");
        }
    }
}
