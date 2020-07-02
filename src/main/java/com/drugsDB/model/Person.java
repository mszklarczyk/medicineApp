package com.drugsDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "PersonInfo")
public class Person {
    public enum dayTimes {morning, noon, evening}

    @Id
    private String id;
    private String personName;
    private List<Integer> defTime=new ArrayList<Integer>();

    public Person(){}
    public Person(String personName, int morning, int noon, int evening) {
        this.personName = personName;
        defTime.add(morning);
        defTime.add(noon);
        defTime.add(evening);
    }
    @PersistenceConstructor
    public Person(String personName, List<Integer> defTime){
        this.setPersonName(personName);
        this.defTime=defTime;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPersonName(){
        return personName;
    }
    public void setPersonName(String personName){
        this.personName=personName;
    }
    public int getDefTime(dayTimes type){
        return defTime.get(type.ordinal());
    }
    @Override
    public String toString(){
        return id+"::"+personName+"::"+defTime;
    }
}
