package com.medicineapp.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PersonInfo")
public class User {

	@Id
	private String userId;
	private String name;
	private Date creationDate = new Date();
	private Map<String, Integer> userSettings = new HashMap<>();

	public User(String userId, String name, Date creationDate, Map<String,Integer> userSettings) {
		this.userId=userId;
		this.name=name;
		this.creationDate=creationDate;
		this.userSettings=userSettings;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Map<String, Integer> getUserSettings() {
		return userSettings;
	}

	public void setUserSettings(Map<String, Integer> userSettings) {
		this.userSettings = userSettings;
	}
}
