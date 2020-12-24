package com.example.linebot.utils;

import java.util.Map;

public class Subject implements Dotws{
    private final String name;
    private final String period;
    private final String dotw;

    public Subject(Map<?, ?> subject) {
        this.name = String.valueOf(subject.get("name"));
        this.period = String.valueOf(subject.get("period"));
        this.dotw = String.valueOf(subject.get("dotw"));
    }

    public String getDotw() {
        return dotw;
    }

    public String getPeriod() {
        return period;
    }

    public String replyMessage() {
        return dotws.get(Integer.parseInt(dotw)) + period + ": " + name;
    }
}
