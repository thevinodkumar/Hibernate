package com.nt.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.UserTable;
import com.nt.util.HibernateUtil;

public class Operations {

	static Session ses = HibernateUtil.getSession();

	public static void insert() {
		UserTable u = new UserTable();
		u.setFirstName("vinod");
		u.setUserId(123);
		
		PhoneNumber p = new PhoneNumber();
		p.setPhone(1234567891);
		p.setNumberType("privacy");
		p.setUserTable(u);
		PhoneNumber p1 = new PhoneNumber();
		p1.setPhone(9874561232l);
		p1.setNumberType("optinal");
		p1.setUserTable(u);
		Set<PhoneNumber> set = new HashSet<PhoneNumber>();
		set.add(p);
		set.add(p1);

		u.setPhoneNumbers(set);
		boolean flag = false;
		Transaction tx = ses.beginTransaction();
		try {
			long n= (Long) ses.save(p);
			long n1= (Long) ses.save(p1);
			flag = true;
			System.out.println(n+" "+n1);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("records are inserted");
			} else {
				tx.rollback();
				System.out.println("records not found");
			}
		}
	}

	public static void select() {
		
		UserTable u=ses.get(UserTable.class, 123L);
		System.out.println(u.getUserId()+" "+u.getFirstName());
		Set<PhoneNumber> set=u.getPhoneNumbers();

		set.forEach(p->{
			System.out.println(p);
		});
	}
	public static void selectPh() {
		
		PhoneNumber ph=ses.get(PhoneNumber.class, 8985977348L);
		UserTable u=		ph.getUserTable();
//		Set<PhoneNumber> set=u.getPhoneNumbers();
//		set.forEach(p->{
//			System.out.println(p);
//		});
		System.out.println(ph.getPhone()+" "+ph.getNumberType());
		System.out.println(u.getUserId()+" "+u.getFirstName());
	}	
}
