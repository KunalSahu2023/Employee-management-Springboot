package com.indiabulls.employeemangementspringboot.service;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
    public class FirestoreService {

    private Firestore firestore;

    public FirestoreService(Firestore firestore) {
        this.firestore = firestore;
    }

    public void saveLog(Long id, String name, String action) {

        try {
            Map<String, Object> data = new HashMap<>();

            data.put("employeeId", id);
            data.put("name", name);
            data.put("action", action);
            data.put("timestamp_firestore", Timestamp.now());

            firestore.collection("employee_logs")
                    .document()
                    .set(data);
            System.out.println("Firestore log saved");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Firestore log save failed");
        }
    }

}
