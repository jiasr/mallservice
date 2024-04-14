package com.us.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.us.example.bean.User;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Repository
public class UserServiceImpl{

	@Autowired
	EntityManager entityManager;

	public void saveUser(User user) {
		 entityManager.persist(user);
	}

	public List<User> getAllUser(){

		TypedQuery<User> query = entityManager.createQuery("SELECT t FROM User t", User.class);
		return query.getResultList();

	}




}
