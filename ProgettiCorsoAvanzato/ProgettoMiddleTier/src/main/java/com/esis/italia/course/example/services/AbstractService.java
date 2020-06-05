package com.esis.italia.course.example.services;

import com.esis.italia.course.example.jpa.dao.GenericDAO;

class AbstractService<T extends GenericDAO> {

	protected T dao;

	/**
	 * @return the dao
	 */
	public T getDao() {
		return dao;
	}

}