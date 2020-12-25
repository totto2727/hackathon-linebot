package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class SetUid extends Reply<MessageEvent<TextMessageContent>> {
    private final String firebaseUid;

    public SetUid(MessageEvent<TextMessageContent> event) {
        super(event);
        firebaseUid = event.getMessage().getText();
    }

    @Override
    public Message reply() {
        try {
            var result = new FirestoreService(lineUid).setUid(firebaseUid);
            if (result) return new TextMessage("連携に成功しました");
            else return new TextMessage("そのUIDを持つユーザーが存在しません");
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データの送信･更新に失敗しました");
        }
    }
}
