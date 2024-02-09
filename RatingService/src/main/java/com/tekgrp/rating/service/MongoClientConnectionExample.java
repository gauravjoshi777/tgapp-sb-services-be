/**
 * This class demonstrates how to establish a connection to MongoDB using the MongoClient.
 * It also sends a ping to confirm the successful connection.
 *
 * @author Gaurav Joshi
 * @since Feb 02, 2024
 */
package com.tekgrp.rating.service;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoClientConnectionExample {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        System.out.println("serverApi: "+serverApi);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        System.out.println("settings: "+settings);
        System.out.println("Create a new client and connect to the server");
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                System.out.println("Send a ping to confirm a successful connection");
                MongoDatabase database = mongoClient.getDatabase("microservicesrating");
                System.out.println("database: "+database);
                database.runCommand(new Document("ping", 1));
                System.out.println("database1111: ");
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}
