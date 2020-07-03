package com.drugsDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "PersonDrug")
public class PersonDrug {
    @Id
    private String id;
    private String personName;
    private String drugName;
    private boolean active;
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    private int addDate;
    private int dosageDay;
    private List<Integer> dosageHour = new ArrayList<Integer>();

    public PersonDrug(String personName, String drugName, boolean active, Date startDate, Date endDate, int addDate, int dosageDay, List<Integer> dosageHour) {
        this.personName=personName;
        this.drugName=drugName;
        this.active=active;
        this.startDate=startDate;
        this.endDate=endDate;
        this.addDate=addDate;
        this.dosageDay=dosageDay;
        this.dosageHour=dosageHour;
    }
    @Override
    public String toString(){
        return "personName: "+personName+": drugName :"+drugName+": active :"+active+": startDate :"+startDate+": endDate :"+endDate+": addDate:"+addDate+": dosageDay:"+dosageDay+": dosageHour:"+dosageHour;
    }
}
