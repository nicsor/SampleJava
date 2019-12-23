package com.sample.persistence.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sample.persistence.dao.DatabaseItf;
import com.sample.persistence.model.Project;
import com.sample.persistence.model.User;

public class DatabaseImpl implements DatabaseItf {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public User addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		session.save(user);
		tx1.commit();

		return user;
	}

	@Override
	public User updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx1 = session.beginTransaction();
		session.update(user);
		tx1.commit();

		return user;
	}

	@Override
	public boolean removeUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();

		if (null != user) {
			Transaction tx1 = session.beginTransaction();
			session.delete(user);
			tx1.commit();

			return true;
		}
		return false;
	}

	@Override
	public List<User> getUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = (Query) session.createQuery("from User");

		return query.list();
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = (Query) session.createQuery("from User WHERE email = :email");

		query.setParameter("email", email);

		List<User> users = query.list();

		for (User user : users) {
			return user;
		}

		return null;
	}

	@Override
	public List<Project> getProjects(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
