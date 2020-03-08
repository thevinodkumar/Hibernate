package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Student stud=null;
		LibraryMembership lib=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		//prepare objects
		stud=new Student();
		stud.setSname("raja");
		stud.setAddrs("hyd");
		
		lib=new LibraryMembership();
		lib.setType("GOLD");
		lib.setDoj(new Date());
		//set parent to child and child to parent
		stud.setLibraryDetails(lib);
		lib.setStudDetails(stud);
		try {
			tx=ses.beginTransaction();
			  ses.save(stud);
			flag=true;
		}
		catch(HibernateException  he){
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	}//class
