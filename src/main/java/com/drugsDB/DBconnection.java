//package com.drugsDB;
//
//import com.mongodb.MongoCredential;
//import com.mongodb.client.*;
//import org.bson.Document;
//
//public class DBconnection {
//    public static final String databaseName = "myDB";
//
//    public static MongoDatabase DBconnect(){
//
//        MongoClient mongo = MongoClients.create();
//        MongoDatabase database = mongo.getDatabase("testDB");
//        return database;
//    }
//
//    public static boolean collectionExist(MongoDatabase db, String collectionName){
//        MongoIterable<String> collection =  db.listCollectionNames();
//        for(String s : collection) {
//            if(s.equals(collectionName)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//}
