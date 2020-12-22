package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GetUid implements Reply{
    private  final MessageEvent<TextMessageContent>event;

    public GetUid(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public Message reply() {
        var lineUid=event.getSource().getUserId();

        String firebaseUid= null;

        try {
            firebaseUid = new FirestoreService().getUid(lineUid);
            if(!firebaseUid.equals("")) return new TextMessage("UID:"+firebaseUid);
            else return new TextMessage("連携されていません\nUIDを登録してください");
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データを取得できませんでした");
        }
    }
}
