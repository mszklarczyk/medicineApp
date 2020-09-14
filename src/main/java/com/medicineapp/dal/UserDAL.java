package com.medicineapp.dal;

import java.util.List;

import com.medicineapp.model.User;

public interface UserDAL {

	List<User> getAllUsers();

	User getUserById(String userId);

	User addNewUser(User user);

	Object getAllUserSettings(String userId);

	int getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, int value);

	List<User> getAllUserByName (String name);
}