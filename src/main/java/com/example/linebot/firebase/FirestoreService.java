package com.example.linebot.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirestoreService {
    private final Firestore db;

    public FirestoreService() throws IOException {
        InputStream serviceAccount = new FileInputStream("timetable-2a507-firebase-adminsdk-cftah-5ae491cb19.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://timetable-2a507.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    public String test(){
        return "test";
    }

    public void setUid(String lineUid, String firebaseUid) throws ExecutionException, InterruptedException {
        var docRef = db.collection("LineConnection").document(lineUid);
        var data = new HashMap<String,String>();
        data.put("firebase",firebaseUid);
        var result = docRef.set(data);
        System.out.println(result.get().getUpdateTime());
    }
}
