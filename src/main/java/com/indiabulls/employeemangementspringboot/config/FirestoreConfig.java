package com.indiabulls.employeemangementspringboot.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirestoreConfig {

    @Bean
    public Firestore firestore() throws IOException {

        InputStream serviceAccount =
                new FileInputStream("D:/Resources/Back End/Java/secret-key.json");


        GoogleCredentials credentials =
                GoogleCredentials.fromStream(serviceAccount);

        FirestoreOptions options =
                FirestoreOptions.newBuilder()
                        .setCredentials(credentials)
                        .build();

        return options.getService();
    }
}
