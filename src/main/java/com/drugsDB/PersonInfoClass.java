package com.drugsDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "PersonInfo")
public class PersonInfoClass {
    public enum dayTimes {morning, noon, evening}

    @Id
    private String id;
    private String personName;
    private List<Integer> defTime=new ArrayList<Integer>();


    public PersonInfoClass(String personName, int morning, int noon, int evening) {
        this.personName = personName;
        defTime.add(morning);
        defTime.add(noon);
        defTime.add(evening);
    }
    @PersistenceConstructor
    public PersonInfoClass(String personName, List<Integer> defTime){
        this.setPersonName(personName);
        this.defTime=defTime;
    }
    public void setPersonName(String personName){
        this.personName=personName;
    }
    public String getPersonName(){
        return personName;
    }
    public int getDefTime(dayTimes type){
        return defTime.get(type.ordinal());
    }
}
