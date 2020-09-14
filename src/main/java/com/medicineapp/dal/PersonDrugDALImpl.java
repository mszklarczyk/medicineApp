package com.medicineapp.dal;

import com.medicineapp.model.PersonDrug;
import com.medicineapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDrugDALImpl implements PersonDrugDAL{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<PersonDrug> getAllPersonsDrug() {
        return mongoTemplate.findAll(PersonDrug.class);
    }

    @Override
    public PersonDrug getPersonByName(String personName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("personName").is(personName));
        return mongoTemplate.findOne(query, PersonDrug.class);
    }

    @Override
    public PersonDrug getPersonDrugByID(String Id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("ID").is(Id));
        return mongoTemplate.findOne(query, PersonDrug.class);
    }
    @Override
    public PersonDrug addNewPersonDrug(PersonDrug personDrug) {
        mongoTemplate.save(personDrug);
        // Now, user object will contain the ID as well
        return personDrug;
    }

    @Override
    public Object getAllDosageHour(String personName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("personName").is(personName));
        PersonDrug personDrug = mongoTemplate.findOne(query, PersonDrug.class);
        return personDrug != null ? personDrug.getDosageHour() : "User not found.";
    }

//    @Override
//    public String addDosageHour(String personName, int value) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("personName").is(personName));
//        PersonDrug personDrug = mongoTemplate.findOne(query, PersonDrug.class);
//        if (personDrug != null) {
//            personDrug.getDosageHour().add(value);
//            mongoTemplate.save(personDrug);
//            return "Key added.";
//        } else {
//            return "User not found.";
//        }
//    }
    @Override
    public String addDosageHour(String personName,  int value) {
        Query query = new Query();
        query.addCriteria(Criteria.where("personName").is(personName));
        PersonDrug person = mongoTemplate.findOne(query, PersonDrug.class);
        if (person != null) {
            person.getDosageHour().add(value);
            mongoTemplate.save(person);
            return "Key added.";
        } else {
            return "User not found.";
        }
    }
    @Override
    public Integer getPersonDosageHour(String personName, int key) {
        Query query = new Query();
        query.fields().include("userSettings");
        query.addCriteria(Criteria.where("userId").is(personName).andOperator(Criteria.where("userSettings." + key).exists(true)));
        PersonDrug person = mongoTemplate.findOne(query, PersonDrug.class);
        return person != null ? person.getDosageHour().get(key) : 0;
    }
    // should return all drugs for specific person
    @Override
    public List<PersonDrug> getAllUserDrug(String personName){
        Query query = new Query();
        query.addCriteria(Criteria.where("personName").is(personName));
        return  mongoTemplate.find(query,PersonDrug.class) ;
    }

}
