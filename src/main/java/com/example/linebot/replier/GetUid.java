package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GetUid extends Reply<MessageEvent<TextMessageContent>> {
    public GetUid(MessageEvent<TextMessageContent> event) {
        super(event);
    }

    @Override
    public Message reply() {
        try {
            var firebaseUid = new FirestoreService(super.lineUid).getUid();
            return new TextMessage("UID:" + firebaseUid);
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データを取得できませんでした");
        } catch (NullPointerException e) {
            return new TextMessage("連携されていません");
        }
    }
}
