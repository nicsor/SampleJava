package com.sample.persistence.dao;

import java.util.List;

import com.sample.persistence.model.User;
import com.sample.persistence.model.Project;

public interface DatabaseItf {
	public User addUser(User user);
	public User updateUser(User user);
	public boolean removeUser(User user);
	public List<User> getUsers();
	public User getUserByEmail(String email);
	public List<Project> getProjects(User user);
}
