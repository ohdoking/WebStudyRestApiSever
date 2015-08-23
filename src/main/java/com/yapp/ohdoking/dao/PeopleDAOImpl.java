package com.yapp.ohdoking.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yapp.ohdoking.model.People;

@Repository
public class PeopleDAOImpl implements PeopleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void savePeople(People p) {

		getSession().save(p);
	}

	public List<People> listPeoples() {
		return getSession().createCriteria(People.class).list();
	}

	public People getPeople(Long id) {
		return (People) getSession().get(People.class, id);
	}

	public void deletePeople(Long id) {

		People people = getPeople(id);

		if (null != people) {
			getSession().delete(people);
		}
	}

	/*private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}
	*/
	public Session getSession() {
	    Session session = null;
	    try { 
	        session = sessionFactory.getCurrentSession();
	    } catch ( HibernateException he ) {
	        session = sessionFactory.openSession();
	    }
	    return session;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}




}