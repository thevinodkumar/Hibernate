package com.nt.dao;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class NGOOperationsDAOImpl implements NGOOperationsDAO {
    //private static final String  HQL_INSERT_QUERY="INSERT INTO NGOMember(mid,name,salary) SELECT e.eid,e.ename,e.salary from Employee e where e.salary>=:minSal and e.salary<=:maxSal";
	private static final String  HQL_INSERT_QUERY="INSERT INTO NGOMember(mid,name,salary) SELECT eid,ename,salary from Employee  where salary>=:minSal and salary<=:maxSal";
	
	@Override
	public int transferEmpsToNGOs(float startSalary, float endSalary) {
		Transaction tx=null;
		boolean flag=false;
		Query query=null;
		int count=0;
		//get Session
		try(Session ses=HibernateUtil.getSession()){
		//prepare Query object
		query=ses.createQuery(HQL_INSERT_QUERY);
		//set values to query params
		query.setParameter("minSal",startSalary);
		query.setParameter("maxSal",endSalary);
			tx=ses.beginTransaction();
			 //execute the query
			count=query.executeUpdate();
			tx.commit();
		}//try
		catch(HibernateException he) {
			tx.rollback();
			he.printStackTrace();
		}
		catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
 	return count;
	}//method
	

}//class
