package com.example.linebot.firebase;

import com.example.linebot.utils.Subject;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class FirestoreService implements IFirestoreService {
    private final DocumentReference connectionDocRef;
    private final CollectionReference timetableColRef;

    public FirestoreService(String lineUid) throws IOException {
        List<FirebaseApp> apps = FirebaseApp.getApps();
        if (apps.size() == 0) {
            InputStream serviceAccount = new FileInputStream("src/main/java/com/example/linebot/firebase/timetable-2a507-firebase-adminsdk-cftah-5ae491cb19.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://timetable-2a507.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        }
        Firestore db = FirestoreClient.getFirestore();
        this.connectionDocRef = db.collection("LineConnection").document(lineUid);
        this.timetableColRef = db.collection("Timetable");
    }

    @Override
    public boolean setUid(String firebaseUid) throws ExecutionException, InterruptedException {
        var existUser = timetableColRef.document(firebaseUid).get().get().exists();
        if (existUser) {
            connectionDocRef.set(Map.of("firebaseUid", firebaseUid));
        }
        return existUser;
    }

    @Override
    public String getUid() throws ExecutionException, InterruptedException, NullPointerException {
        var query = connectionDocRef.get();
        var document = query.get();
        var data = document.getData();
        return Objects.requireNonNull(data).get("firebaseUid").toString();
    }

    @Override
    public List<Subject> getSubjects() throws ExecutionException, InterruptedException, NullPointerException {
        var firebaseUid = getUid();
        var docRef = timetableColRef.document(firebaseUid);
        var query = docRef.get();
        var document = query.get();
        var data = document.getData();
        return Objects.requireNonNull(data).values().stream()
                .filter(v -> v instanceof Map)
                .map(v -> (Map<?, ?>) v)
                .filter(v -> v.get("name") != null && v.get("name") != "")
                .map(Subject::new)
                .sorted(Comparator.comparing(Subject::getDotw).thenComparing(Subject::getPeriod))
                .collect(Collectors.toList());
    }
}
