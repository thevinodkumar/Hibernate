package com.nt.test;

import org.hibernate.Session;

import com.nt.domain.Student;
import com.nt.util.HibernateUtil;

public class ClietTest {

	public static void main(String[] args) throws InterruptedException {
		Session ses = HibernateUtil.getSession();
		Student s = ses.get(Student.class, 33);
		//Student s = ses.load(Student.class, 33);
		System.out.println(s);
			
		//from 1st level cache
		Student s1 = ses.load(Student.class, 33);
		System.out.println(s1);
		ses.clear();
		//from second cache
		Student s2 = ses.load(Student.class, 33);
		System.out.println(s2);
		ses.clear();
		Thread.sleep(10000);
		//from database
		Student s3 = ses.load(Student.class, 33);
		System.out.println(s3);
		
		
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
