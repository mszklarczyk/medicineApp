package com.drugsDB.main;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.net.UnknownHostException;

import com.drugsDB.model.Person;
import com.mongodb.MongoClient;

public class SpringMongoMain {
    public static final String DB_NAME = "testDB";
    public static final String PERSON_COLLECTION = "PersonInfo";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    public static void main(String[] args){
        //addPerson();
        dropPersonCollection();
    }


    public static void test() {
        try {
            MongoClient mongo = new MongoClient(
                    MONGO_HOST, MONGO_PORT);
            //MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
            MongoOperations mongoOps = new MongoTemplate((com.mongodb.client.MongoClient) mongo, DB_NAME);
            Person p = new Person( "PankajKr",8,12,19);
            mongoOps.insert(p, PERSON_COLLECTION);

            Person p1 = mongoOps.findOne(
                    new Query(Criteria.where("name").is("PankajKr")),
                    Person.class, PERSON_COLLECTION);

            System.out.println(p1);

            mongoOps.dropCollection(PERSON_COLLECTION);
            mongo.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public static void addPerson(){
        try {
            MongoClient mongo = new MongoClient(
                    MONGO_HOST, MONGO_PORT);
            MongoOperations mongoOps = new MongoTemplate((com.mongodb.client.MongoClient) mongo, DB_NAME);
            Person p = new Person( "PankajKr",8,12,19);
            mongoOps.insert(p, PERSON_COLLECTION);

            Person p1 = new Person( "Tomek", 8,12,18);
            mongoOps.insert(p1, PERSON_COLLECTION);

            Person p2 = new Person( "Marek",7,14,21);
            mongoOps.insert(p2, PERSON_COLLECTION);

            Person p3 = new Person( "Jacek", 9,13,20);
            mongoOps.insert(p3, PERSON_COLLECTION);

            mongo.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public static void dropPersonCollection(){
        try {
            MongoClient mongo = new MongoClient(
                    MONGO_HOST, MONGO_PORT);
            MongoOperations mongoOps = new MongoTemplate((com.mongodb.client.MongoClient) mongo, DB_NAME);

            mongoOps.dropCollection(PERSON_COLLECTION);
            mongo.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}