package com.example.linebot.replier;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.message.Message;

public class Reply<T extends Event> implements IReply{
    protected final T event;
    protected final String lineUid;

    public Reply(T event) {
        this.event = event;
        this.lineUid=event.getSource().getUserId();
    }

    @Override
    public Message reply() {
        return null;
    }
}
