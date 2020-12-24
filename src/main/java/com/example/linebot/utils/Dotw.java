package com.example.linebot.utils;

public enum Dotw {
    Mon ("1","月"),
    Tue ("2","火"),
    Wen ("3","水"),
    Thu ("4","木"),
    Fri ("5","金"),
    Sat ("6","土"),
    Sun ("7","日"),
    ;

    private final String i;
    private final String dotw;
    Dotw(String i, String dotw) {
        this.i=i;
        this.dotw=dotw;
    }

    public String getDotw() {
        return dotw;
    }

    public String getI() {
        return i;
    }

    public static String searchDotw(String i) {
        for (var dotw: Dotw.values()) {
            if(i.equals(dotw.getI())) return dotw.getDotw();
        }
        return null;
    }
}
