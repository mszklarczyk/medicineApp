package com.medicineapp.dal;

import com.medicineapp.model.PersonDrug;
import com.medicineapp.model.User;

import java.util.List;

public interface PersonDrugDAL {
    List<PersonDrug> getAllPersonDrug();

    PersonDrug getPersonById(String personId);

    PersonDrug getPersonDrugByID(String Id);

    PersonDrug addNewPersonDrug(PersonDrug personDrug);

    Object getAllDosageHour(String personId);

    String addDosageHour(String personId, int value);

    String getAllUserDrug(String personId);     // should return all drugs for specific person
}
