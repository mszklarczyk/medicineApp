package com.medicineapp.Test;

import com.medicineapp.model.PersonDrug;
import com.medicineapp.model.User;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.jws.soap.SOAPBinding;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.medicineapp.helperMethod.*;

public class DBconnection {

    public static final String DB_NAME = "drugDB";
    public static final String PERSON_COLLECTION = "PersonInfo";
    public static final String PERSON_DRUG_COLLECTION="PersonDrug";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    public static void main(String[] args) throws UnknownHostException {
        addPerson();
        addPersonDrug();
        //findTest();

    }

    public static void findTest() throws UnknownHostException {
        MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
        MongoOperations mongoOps = new MongoTemplate( mongo, DB_NAME);

        User p1 = mongoOps.findOne(
                new Query(Criteria.where("personName").is("Tomek")),
                User.class, PERSON_COLLECTION);

        mongo.close();
    }

    public static void addPerson(){
        MongoClient mongo = new MongoClient(
                MONGO_HOST, MONGO_PORT);
        MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);

        mongoOps.dropCollection(PERSON_COLLECTION);

        Map <String,Integer> hm1=new HashMap<>();
        hm1.put("morning",8);
        hm1.put("noon",12);
        hm1.put("evening",19);

        User u1 = new User( null,"Tomek",new Date(),hm1);
        mongoOps.insert(u1, PERSON_COLLECTION);

        User u2 = new User(null,"Marek",dateAdd(new Date(),-2),hm1);
        mongoOps.insert(u2,PERSON_COLLECTION);

        User u3 = new User(null,"Marcin",dateAdd(new Date(),2),hm1);
        mongoOps.insert(u3,PERSON_COLLECTION);

        mongo.close();
    }
    public static void addPersonDrug(){
        MongoClient mongo = new MongoClient(
                MONGO_HOST, MONGO_PORT);
        MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);

        mongoOps.dropCollection(PERSON_DRUG_COLLECTION);

        PersonDrug p1 = new PersonDrug("Tomek","Ibuprom",true,dateAdd(new Date(),0),null,getDayNumber(new Date()),1, Arrays.asList(8,13,19));
        mongoOps.insert(p1, PERSON_DRUG_COLLECTION);

        PersonDrug p2 = new PersonDrug("Tomek","Paracetamol",true,dateAdd(new Date(),0),null,getDayNumber(new Date()),1, Arrays.asList(8,13,19));
        mongoOps.insert(p2, PERSON_DRUG_COLLECTION);

        PersonDrug p3 = new PersonDrug("Marek","Ibuprom",true,dateAdd(new Date(),0),null,getDayNumber(new Date()),1, Arrays.asList(8,13,19));
        mongoOps.insert(p3, PERSON_DRUG_COLLECTION);

        PersonDrug p4 = new PersonDrug("Marek","Paracetamol",true,dateAdd(new Date(),0),null,getDayNumber(new Date()),1, Arrays.asList(8,13,19));
        mongoOps.insert(p4, PERSON_DRUG_COLLECTION);

        PersonDrug p5 = new PersonDrug("Marek","Paracetamol",false,dateAdd(new Date(),0),null,getDayNumber(new Date()),1, Arrays.asList(8,13,19));
        mongoOps.insert(p5, PERSON_DRUG_COLLECTION);

        mongo.close();
    }
}
