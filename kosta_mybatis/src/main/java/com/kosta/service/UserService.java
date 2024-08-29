package com.kosta.service;

import java.util.List;

import com.kosta.dto.User;

public interface UserService {

	boolean addUser(User user);

	String deleteUser(int id) throws Exception;

	User getUserById(int id) throws Exception;

	List<User> getAll() throws Exception;

	User modifyUser(User user);

}
