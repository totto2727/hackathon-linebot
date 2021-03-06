package com.example.linebot.utils;

import java.util.Map;

public class Subject implements ISubject {
    private final String name;
    private final String period;
    private final String dotw;

    public Subject(Map<?, ?> subject) {
        this.name = String.valueOf(subject.get("name"));
        this.period = String.valueOf(subject.get("period"));
        this.dotw = String.valueOf(subject.get("dotw"));
    }

    @Override
    public String getDotw() {
        return dotw;
    }

    @Override
    public String getPeriod() {
        return period;
    }

    @Override
    public String replyMessage() {
        return Dotws.searchDotw(dotw) + period + ": " + name;
    }
}
