package com.drugsDB;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "DrugsDB")
public class DrugClass {

    @Id
    private String id;
    private String name;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date createdDate;
    @Indexed
    private boolean active;
    private String activeSubstance;

    public DrugClass(String name, Date createdDate, boolean active) {
        this.name = name;
        this.createdDate=createdDate;
        this.active=active;
    }

    //getter and setter methods

}

