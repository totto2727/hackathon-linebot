package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GetUid implements Reply {
    private final MessageEvent<TextMessageContent> event;

    public GetUid(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var lineUid = event.getSource().getUserId();

        try {
            var firebaseUid = new FirestoreService().getUid(lineUid);
            return new TextMessage("UID:" + firebaseUid);
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データを取得できませんでした");
        } catch (NullPointerException e) {
            return new TextMessage("連携されていません");
        }
    }
}
