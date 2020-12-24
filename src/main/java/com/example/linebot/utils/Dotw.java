package com.example.linebot.utils;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Dotw {
    Mon (1,"月"),
    Tue (2,"火"),
    Wen (3,"水"),
    Thu (4,"木"),
    Fri (5,"金"),
    Sat (6,"土"),
    Sun (7,"日"),
    ;

    private final int i;
    private final String dotw;
    Dotw(int i, String dotw) {
        this.i=i;
        this.dotw=dotw;
    }

    public String getDotw() {
        return dotw;
    }

    public int getI() {
        return i;
    }

    public static String searchDotw(int i) {
        for (var dotw:
             Dotw.values()) {
            if(i== dotw.getI()) return dotw.getDotw();
        }
        return null;
    }
}
