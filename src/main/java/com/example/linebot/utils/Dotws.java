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

    public static String searchIndex(String str){
        return Arrays.stream(Dotws.values())
                .filter(v->str.equals(v.getDotw()))
                .findFirst()
                .orElse(Dotws.valueOf("0"))
                .getIndex();
    }

    public static String searchDotw(String i) {
        return Arrays.stream(Dotws.values())
                .filter(v -> i.equals(v.getIndex()))
                .findFirst()
                .orElse(Dotws.valueOf("Error"))
                .getDotw();
    }

    public static Boolean isDotw(String str){
        return Dotws.getDotwsList().contains(str);
    }
}
