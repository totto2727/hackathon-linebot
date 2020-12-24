package com.example.linebot.firebase;

import com.example.linebot.utils.Subject;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IFirestoreService {
    boolean setUid(String firebaseUid) throws ExecutionException, InterruptedException;
    String getUid() throws ExecutionException, InterruptedException, NullPointerException;
    List<Subject> getSubjects() throws ExecutionException, InterruptedException, NullPointerException;
}
