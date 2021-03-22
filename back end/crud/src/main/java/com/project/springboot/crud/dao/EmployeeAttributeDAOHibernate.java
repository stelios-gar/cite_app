package com.project.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeAttributeDAOHibernate implements EmployeeAttributeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeAttributeDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Integer> getAttrByEmpId(int employeeId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				currentSession.createQuery("select attributeId from EmployeeAttribute where "
						+ "employee_id=:employeeId");
		theQuery.setParameter("employeeId", employeeId);
		theQuery.list();

		return theQuery.getResultList();
	}

	@Override
	public void save(int employeeId,List<Integer> attributesList) {
		Session currentSession = entityManager.unwrap(Session.class);
		String valuesList="";
		if(!attributesList.isEmpty()) {
			valuesList="("+employeeId+","+attributesList.get(0)+")";
		}else {
			return;
		}
		
		for(int i=1; i<attributesList.size(); i++) {
			valuesList = valuesList+",("+employeeId+","+attributesList.get(i)+")";
		}
		
		Query theQuery = 
				currentSession.createNativeQuery("insert into EmployeeAttribute (employee_id,attribute_id) "
						+ "values "+valuesList);
		
//		theQuery.setParameter("valuesList", valuesList);
		theQuery.executeUpdate();

	}

	@Override
	public void deleteById(int employeeId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				currentSession.createQuery("delete from EmployeeAttribute where "
						+ "employee_id=:employeeId");
		theQuery.setParameter("employeeId", employeeId);
		theQuery.executeUpdate();

	}

	@Override
	public List<Integer> getEmpByAttrId(int attributeId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = 
				currentSession.createQuery("select employeeId from EmployeeAttribute where "
						+ "attribute_id=:attributeId");
		theQuery.setParameter("attributeId", attributeId);
		theQuery.list();

		return theQuery.getResultList();
	}



}
