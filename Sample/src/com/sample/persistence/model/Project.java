package com.sample.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Projects")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int projectId;
	private String name;
	private int managerId;

	@ManyToMany(mappedBy = "projects")
	private Set<User> users = new HashSet<>();

	public Set<User> getUsers() {
		return users;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
