package com.sample.controller;


import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.business.UsersManagerItf;
import com.sample.commons.dto.Login;
import com.sample.commons.dto.UserInfo;
import com.sample.persistence.dao.DatabaseItf;

@RestController
@Path("/users")
public class UsersController {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getUserById(@PathVariable("id") int utilizatorID) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersManagerItf business = (UsersManagerItf) context.getBean("business");

		return null;
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo login(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Login loginInfo = mapper.readValue(json, Login.class);

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UsersManagerItf business = (UsersManagerItf) context.getBean("business");

			UserInfo response = business.getUserInfo(loginInfo);

			return response;
		} catch (Exception e) {
			// JsonParseException JsonMappingException IOException
			e.printStackTrace();
			System.out.println("exceptie " + e);
			return null;
		}
	}
}
