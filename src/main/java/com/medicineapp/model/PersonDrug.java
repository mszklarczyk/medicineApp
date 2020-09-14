package com.medicineapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Document(collection = "PersonDrug")
public class PersonDrug {
    @Id
    private String Id;
    private String personName;
    private String drugName;
    private boolean active;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    private int addDate;
    private int dosageDay;
    //private Map<String,Integer> dosageHour = new HashMap<>();
    private List<Integer> dosageHour = new ArrayList<Integer>();

        public PersonDrug(String personName, String drugName, boolean active, Date startDate, Date endDate, int addDate, int dosageDay, List<Integer> dosageHour) {
            this.personName = personName;
            this.drugName = drugName;
            this.active = active;
            this.startDate = startDate;
            this.endDate = endDate;
            this.addDate = addDate;
            this.dosageDay = dosageDay;
            this.dosageHour = dosageHour;
        }
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String PersonName) {
        this.personName = personName;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAddDate() {
        return addDate;
    }

    public void setAddDate(int addDate) {
        this.addDate = addDate;
    }

    public int getDosageDay() {
        return dosageDay;
    }

    public void setDosageDay(int dosageDay) {
        this.dosageDay = dosageDay;
    }

    public List<Integer>getDosageHour(){
        return dosageHour;
    }

    public void setDosageHour(List<Integer> dosageHour) {
        this.dosageHour = dosageHour;
    }

    @Override
    public String toString(){
        return "personName: "+personName+": drugName :"+drugName+": active :"+active+": startDate :"+startDate+": endDate :"+endDate+": addDate:"+addDate+": dosageDay:"+dosageDay+": dosageHour:"+dosageHour;
    }
}
