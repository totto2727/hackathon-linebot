package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;

import com.example.linebot.utils.Subject;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AllSubjects implements Reply {
    private final MessageEvent<TextMessageContent> event;

    public AllSubjects(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var lineUid = event.getSource().getUserId();
        try {
            var subjects =new FirestoreService().getSubjects(lineUid);
            var message=subjects.stream().map(Subject::showSubject).collect(Collectors.joining("\n"));
            return new TextMessage(message);
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データの取得に失敗しました");
        }catch (NullPointerException e){
            return new TextMessage("データがありません");
        }
    }
}
