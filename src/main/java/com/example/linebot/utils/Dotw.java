package com.example.linebot.utils;

import java.util.Arrays;
import java.util.Objects;

public enum Dotw {
    Mon("1", "月"),
    Tue("2", "火"),
    Wen("3", "水"),
    Thu("4", "木"),
    Fri("5", "金"),
    Sat("6", "土"),
    Sun("7", "日"),
    Error("0","曜日不明")
    ;

    private final String i;
    private final String dotw;

    Dotw(String i, String dotw) {
        this.i = i;
        this.dotw = dotw;
    }

    public String getDotw() {
        return dotw;
    }

    public String getI() {
        return i;
    }

    public static String searchDotw(String i) {
        return Arrays.stream(Dotw.values())
                .filter(v -> i.equals(v.getI()))
                .findFirst()
                .orElse(Dotw.valueOf("Error"))
                .getDotw();
    }
}
