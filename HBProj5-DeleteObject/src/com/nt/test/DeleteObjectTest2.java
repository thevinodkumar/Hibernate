package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Event;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Event event=null;
		//Get Session object
		ses=HibernateUtil.getSession();
		//Load object
		event=ses.get(Event.class,102);
		if(event!=null) {
		try {
			tx=ses.beginTransaction();
			  //create object for deletion
			ses.delete(event);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag) {
				 tx.commit();
				 System.out.println("Object Deleted");
			}
			else {
				tx.rollback();
				 System.out.println("Object not deleted");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		}
		else {
			System.out.println("record not found to delete");
		}
	}//main
}//class
