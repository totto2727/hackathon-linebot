package com.example.linebot.replier;

import com.example.linebot.firebase.FirestoreService;
import com.example.linebot.utils.Dotws;
import com.example.linebot.utils.ShareData;
import com.example.linebot.utils.Subject;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class DotwSubjects extends Reply<MessageEvent<TextMessageContent>> {
    private final String text;

    public DotwSubjects(MessageEvent<TextMessageContent> event) {
        super(event);
        this.text=super.event.getMessage().getText();
    }

    @Override
    public Message reply() {
        try {
            var dotw = String.valueOf(Dotws.searchIndex(text));
            var message = new FirestoreService(super.lineUid).getSubjects().stream()
                    .filter(s -> s.getDotw().equals(dotw))
                    .map(Subject::replyMessage)
                    .collect(Collectors.joining("\n"));
            return new TextMessage(message);
        } catch (ExecutionException | InterruptedException | IOException e) {
            return new TextMessage("データの取得に失敗しました");
        } catch (NullPointerException e) {
            return new TextMessage("授業はありません");
        }
    }
}
