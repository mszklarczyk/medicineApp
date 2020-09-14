package com.medicineapp.controller;

import com.medicineapp.dal.PersonDrugDAL;
import com.medicineapp.dal.PersonDrugRepository;
import com.medicineapp.dal.UserDAL;
import com.medicineapp.dal.UserRepository;
import com.medicineapp.model.PersonDrug;
import com.medicineapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class PersonDrugController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final PersonDrugRepository personDrugRepository;

    private final PersonDrugDAL personDrugDAL;

    public PersonDrugController(PersonDrugRepository personDrugRepository, PersonDrugDAL personDrugDAL) {
        this.personDrugRepository = personDrugRepository;
        this.personDrugDAL = personDrugDAL;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PersonDrug addNewPersonDrug(@RequestBody PersonDrug personDrug) {
        LOG.info("Saving person drug.");
        return personDrugRepository.save(personDrug);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PersonDrug> getAllPersonsDrug() {
        LOG.info("Getting all person drugs.");
        return personDrugRepository.findAll();
    }
    //Get List of PersonDrugs by person name
    @RequestMapping(value = "/{personName}", method = RequestMethod.GET)
    public List<PersonDrug> getPersonDrug(@PathVariable String personName) {
        LOG.info("Getting person drug with name: {}.", personName);
        return personDrugDAL.getAllUserDrug(personName);
    }

    //Get person drug by id
//	@RequestMapping(value = "/{Id}", method = RequestMethod.GET)
//	public PersonDrug getPersonDrug(@PathVariable String Id) {
//		LOG.info("Getting person drug with ID: {}.", Id);
//		return personDrugRepository.findOne(Id);
//	}


//     @RequestMapping(value = "/dosageHour/{Id}", method = RequestMethod.GET)
//     public Object getAllDosageHour(@PathVariable String Id) {
//        PersonDrug personDrug = personDrugRepository.findOne(Id);
//     if (personDrug != null) {
//     return personDrug.getDosageHour();
//     } else {
//     return "Person drug not found.";
//     }
//     }

    @RequestMapping(value = "/dosageHour/{Id}", method = RequestMethod.GET)
    public Object getAllDosageHour(@PathVariable String Id) {
        PersonDrug personDrug = personDrugRepository.findOne(Id);
        if (personDrug != null) {
            return personDrugDAL.getAllDosageHour(Id);
        } else {
            return "User not found.";
        }
    }

//     @RequestMapping(value = "/dosageHour/{Id}/{key}", method =
//     RequestMethod.GET)
//     public Integer getPersonDosageHour(@PathVariable String Id, @PathVariable
//     String key) {
//     //User user = userRepository.findOne(userId);
//     Integer setting = personDrugDAL.getPersonDosageHour(Id, key);
//     LOG.info("Setting = "+setting);
//     if (setting != null) {
//     return setting;
//     } else {
//     return 0;
//     }
//     }

    @RequestMapping(value = "/dosageHour/{Id}/{value}", method = RequestMethod.GET)
    public Integer getPersonDosageHour(@PathVariable String Id, @PathVariable int value) {
        return personDrugDAL.getPersonDosageHour(Id, value);
    }

    @RequestMapping(value = "/dosageHour/{Id}/{value}", method = RequestMethod.GET)
    public String addDosageHour(@PathVariable String Id, @PathVariable Integer value) {
        PersonDrug personDrug = personDrugRepository.findOne(Id);
        if (personDrug != null) {
            personDrug.getDosageHour().add(value);
            personDrugRepository.save(personDrug);
            return "Key added";
        } else {
            return "User not found.";
        }
    }
}
