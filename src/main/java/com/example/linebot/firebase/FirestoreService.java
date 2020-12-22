package com.example.linebot.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirestoreService {
    Firestore db;

    public FirestoreService() throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setDatabaseUrl("https://timetable-2a507.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    public void setUid(String lineUid, String firebaseUid) throws ExecutionException, InterruptedException {
        var docRef = db.collection("LineConnection").document(lineUid);
        var data = new HashMap<String,String>();
        data.put("firebase",firebaseUid);
        var result = docRef.set(data);
        System.out.println(result.get().getUpdateTime());
    }
}
