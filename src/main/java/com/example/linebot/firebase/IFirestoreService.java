package com.example.linebot.firebase;

import com.example.linebot.utils.Subject;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IFirestoreService {
    public boolean setUid(String firebaseUid) throws ExecutionException, InterruptedException;
    public String getUid() throws ExecutionException, InterruptedException, NullPointerException;
    public List<Subject> getSubjects() throws ExecutionException, InterruptedException, NullPointerException;
}
