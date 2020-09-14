package com.medicineapp.dal;

import com.medicineapp.model.PersonDrug;
import com.medicineapp.model.User;

import java.util.List;

public interface PersonDrugDAL {
    List<PersonDrug> getAllPersonsDrug();

    PersonDrug getPersonByName(String personName);

    PersonDrug getPersonDrugByID(String Id);

    PersonDrug addNewPersonDrug(PersonDrug personDrug);

    Object getAllDosageHour(String personName);

    Integer getPersonDosageHour(String personName, int key);

    String addDosageHour(String personName,  int value);

    List<PersonDrug> getAllUserDrug(String personName);     // should return all drugs for specific person
}
