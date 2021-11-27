package com.example.linebot.replier;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class NotificatonService {
    private static final Logger log = LoggerFactory.getLogger(NotificatonService.class);

    private final LineMessagingClient lineMessagingClient;

    @Autowired
    public NotificatonService(LineMessagingClient lineMessagingClient) {
        this.lineMessagingClient = lineMessagingClient;
    }

    @Scheduled(cron = "0 * * * * *", zone = "Asia/Tokyo")
    public void pushNotification() {
        var pushMessage = new PushMessage("Ue68892dce0f152aa5c636830c283fd66", new TextMessage("食べ物の賞味期限が2022/10/28に切れます"));
        try {
            var response = lineMessagingClient.pushMessage(pushMessage).get();
            log.info("Sent messages: {}", response);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}