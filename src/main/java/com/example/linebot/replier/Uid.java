package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Uid implements Reply{
    private final MessageEvent<TextMessageContent> event;

    public Uid(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var lineUid=event.getSource().getUserId();
        var firebaseUid=event.getMessage().getText();
        try {
            new FirestoreService().setUid(lineUid,firebaseUid);
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("連携に失敗しました");
        }
        return new TextMessage("連携に成功しました");
    }
}
