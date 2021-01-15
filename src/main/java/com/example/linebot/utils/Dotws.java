package com.example.linebot.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Dotws {
    Mon("1", "月"),
    Tue("2", "火"),
    Wen("3", "水"),
    Thu("4", "木"),
    Fri("5", "金"),
    Sat("6", "土"),
    Sun("7", "日"),
    Error("0", "曜日不明");

    private final String index;
    private final String dotw;

    Dotws(String i, String dotw) {
        this.index = i;
        this.dotw = dotw;
    }

    public String getDotw() {
        return dotw;
    }

    public String getIndex() {
        return index;
    }

    public static List<String> getDotwsList(){
        return Arrays.stream(Dotws.values()).map(Dotws::getDotw).collect(Collectors.toList());
    }

    public static String searchIndex(String dotw){
        return Arrays.stream(Dotws.values())
                .filter(v->v.getDotw().equals(dotw))
                .findFirst()
                .orElse(Dotws.valueOf("Error"))
                .getIndex();
    }

    public static String searchDotw(String index) {
        return Arrays.stream(Dotws.values())
                .filter(v -> v.getIndex().equals(index))
                .findFirst()
                .orElse(Dotws.valueOf("Error"))
                .getDotw();
    }

    public static Boolean isDotw(String dotw){
        return Dotws.getDotwsList().contains(dotw);
    }
}
