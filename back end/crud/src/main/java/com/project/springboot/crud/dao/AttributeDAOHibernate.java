package com.project.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.crud.entity.Attribute;
import com.project.springboot.crud.entity.Employee;

@Repository
public class AttributeDAOHibernate implements AttributeDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public AttributeDAOHibernate(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}

	@Override
	public List<Attribute> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Attribute> theQuery = 
				currentSession.createQuery("from Attribute",Attribute.class);
		
		List<Attribute> attributes = theQuery.getResultList();
		
		return attributes;
	}

	@Override
	public Attribute findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Attribute attribute = currentSession.get(Attribute.class, id);
		return attribute;
	}

	@Override
	public void save(Attribute attribute) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(attribute);

	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				currentSession.createQuery("delete from Attribute where id=:attributeId");
		theQuery.setParameter("attributeId", id);
		
		theQuery.executeUpdate();

	}

}
