package com.esis.italia.course.example.jpa.dao;

import javax.persistence.EntityManager;

public interface GenericDAO {

	/**
	 * @return the entityManager
	 */
	EntityManager getEntityManager();

}