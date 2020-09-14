package com.medicineapp.dal;

import com.medicineapp.model.PersonDrug;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDrugRepository extends MongoRepository<PersonDrug, String> {
}
