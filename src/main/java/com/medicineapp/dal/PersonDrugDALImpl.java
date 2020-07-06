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
    public List<PersonDrug> getAllPersonDrug() {
        return mongoTemplate.findAll(PersonDrug.class);
    }

    @Override
    public PersonDrug getPersonById(String personId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("personID").is(personId));
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
    public Object getAllDosageHour(String Id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Id").is(Id));
        PersonDrug personDrug = mongoTemplate.findOne(query, PersonDrug.class);
        return personDrug != null ? personDrug.getDosageHour() : "User not found.";
    }

    @Override
    public String addDosageHour(String Id, int value) {
        Query query = new Query();
        query.addCriteria(Criteria.where("Id").is(Id));
        PersonDrug personDrug = mongoTemplate.findOne(query, PersonDrug.class);
        if (personDrug != null) {
            personDrug.getDosageHour().add(value);
            mongoTemplate.save(personDrug);
            return "Key added.";
        } else {
            return "User not found.";
        }
    }

    // should return all drugs for specific person
    @Override
    public String getAllUserDrug(String personId){
        Query query = new Query();
        query.addCriteria(Criteria.where("personID").is(personId));
        PersonDrug personDrug = mongoTemplate.findOne(query, PersonDrug.class);
        return personDrug != null ? personDrug.getDrugName() : "User not found.";
    }
}
