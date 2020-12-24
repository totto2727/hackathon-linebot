package com.example.linebot.utils;

import java.util.Map;

public class Subject {
    private String name;
    private int period;
    private int dotw;

    public Subject(Map<?,?> subject) {
        this.name = String.valueOf(subject.get("name"));
        this.period = (int) subject.get("period");
        this.dotw = (int) subject.get("dotw");
    }

    public String showSubject(){
        return Dotw.searchDotw(dotw)+ period +name;
    }
}
