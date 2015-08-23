package com.yapp.ohdoking.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yapp.ohdoking.dao.PeopleDAO;
import com.yapp.ohdoking.model.People;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	private PeopleDAO peopleDao;

	@Transactional
	public void savePeople(People people) {
		peopleDao.savePeople(people);
	}

	@Transactional(readOnly = true)
	public List<People> listPeoples() {
		return peopleDao.listPeoples();
	}

	@Transactional(readOnly = true)
	public People getPeople(Long id) {
		return peopleDao.getPeople(id);
	}

	@Transactional
	public void deletePeople(Long id) {
		peopleDao.deletePeople(id);

	}

	@Transactional
	public List<People> getPeopleAll() {
		
		return peopleDao.listPeoples();
	}
}