package com.drugsDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "PersonDrug")
public class PersonDrugClass {
    @Id
    private String id;
    private String personId;
    private String drugName;
    private boolean active;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;
    private int addDate;
    private int dosageDay;
    private List<Integer> dosageHour = new ArrayList<Integer>();

    public PersonDrugClass(String personId, String drugName, boolean active, Date startDate, Date endDate, int addDate,int dosageDay, List<Integer> dosageHour) {
        this.personId=personId;
        this.drugName=drugName;
        this.active=active;
        this.startDate=startDate;
        this.endDate=endDate;
        this.addDate=addDate;
        this.dosageDay=dosageDay;
        this.dosageHour=dosageHour;
    }
}
