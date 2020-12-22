package com.example.linebot.firebase;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
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
        FileInputStream serviceAccount =
                new FileInputStream("./timetable-2a507-firebase-adminsdk-cftah-5ae491cb19.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://timetable-2a507.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    public void setUid(String lineUid, String firebaseUid) throws ExecutionException, InterruptedException {
        var docRef = db.collection("LineConnection").document(lineUid);
        var data = Map.of("firebase",firebaseUid);
        var result = docRef.set(data);
        System.out.println(result.get().getUpdateTime());
    }
}
