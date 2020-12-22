package com.example.linebot.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirestoreService {
    private final Firestore db;

    public FirestoreService() throws IOException {
        List<FirebaseApp> apps = FirebaseApp.getApps();
        if (apps.size() == 0) {
            InputStream serviceAccount = new FileInputStream("src/main/java/com/example/linebot/firebase/timetable-2a507-firebase-adminsdk-cftah-5ae491cb19.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://timetable-2a507.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        }
        db = FirestoreClient.getFirestore();
    }

    public void setUid(String lineUid, String firebaseUid) throws ExecutionException, InterruptedException {
        var docRef = db.collection("LineConnection").document(lineUid);
        var data = new HashMap<String, String>();
        data.put("firebase", firebaseUid);
        var result = docRef.set(data);
        System.out.println(result.get().getUpdateTime());
    }

    public String getUid(String lineUid) throws ExecutionException, InterruptedException{
        var docRef = db.collection("LineConnection").document(lineUid);
        var query = docRef.get();
        var document = query.get();
        var data = document.getData();
        if (data != null) return data.get("firebase").toString();
        else return "";

    }
}
