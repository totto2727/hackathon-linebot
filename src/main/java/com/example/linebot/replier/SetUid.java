package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class SetUid implements Reply{
    private final MessageEvent<TextMessageContent> event;

    public SetUid(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var lineUid=event.getSource().getUserId();
        var firebaseUid=event.getMessage().getText();
        try {
            new FirestoreService().setUid(lineUid,firebaseUid);
            return new TextMessage("連携に成功しました");
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データの送信･更新に失敗しました");
        }
    }
}
