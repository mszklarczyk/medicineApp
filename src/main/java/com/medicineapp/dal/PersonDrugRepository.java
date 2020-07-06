package com.medicineapp.dal;

import com.medicineapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDrugRepository extends MongoRepository<User, String> {
}
