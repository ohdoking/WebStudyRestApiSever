package com.yapp.ohdoking.service;

import java.util.List;
import java.util.Map;

import com.yapp.ohdoking.model.People;

public interface PeopleService {

	/*
	 * CREATE and UPDATE
	 */
	public void savePeople(People People);

	/*
	 * READ
	 */
	public List<People> listPeoples();

	public People getPeople(Long id);

	/*
	 * DELETE
	 */
	public void deletePeople(Long id);

	public List<People> getPeopleAll();

}