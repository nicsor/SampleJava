package com.sample.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sample.business.UsersManagerItf;
import com.sample.commons.dto.Login;
import com.sample.commons.dto.UserInfo;
import com.sample.persistence.dao.DatabaseItf;
import com.sample.persistence.model.Project;
import com.sample.persistence.model.User;

public class UsersManagerImpl implements UsersManagerItf {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Override
	public boolean checkCredentials(Login loginInfo) {
		return (getUserInfo(loginInfo) != null);
	}

	@Override
	public UserInfo getUserInfo(Login loginInfo) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DatabaseItf database = (DatabaseItf) context.getBean("database");

		User user = database.getUserByEmail(loginInfo.getUsername());

		if ((user != null) && (loginInfo.getPassword().equals(user.getPassword()))) {
			UserInfo userInfo = new UserInfo();
			userInfo.setName(user.getName());
			userInfo.setUsername(user.getEmail());

			List<String> projects = new ArrayList<String>();
			for (Project project : user.getProjects()) {
				projects.add(project.getName());
			}
			userInfo.setProjects(projects);

			return userInfo;
		}

		return null;
	}
}
