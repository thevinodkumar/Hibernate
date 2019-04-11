package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.domain.Person;
import com.nt.domain.Phno;
import com.nt.util.HibernateUtil;

public class Dao {

	public Dao() {
		System.out.println("Dao.Dao()");
	}

	private Session ses = HibernateUtil.getSession();

	public void saveObject() {
		boolean b = false;
		Set<Phno> set = new HashSet();
		Phno ph = new Phno();
		ph.setPh1(8985977348L);
		ph.setType("personal");

		Phno ph1 = new Phno();
		ph1.setPh1(9052153355L);
		ph1.setType("others");

		set.add(ph);
		set.add(ph1);

		Person p = new Person();
		p.setName("naveen");
		p.setSet(set);
		Transaction tx = null;
		tx = ses.beginTransaction();
		try {
			ses.save(p);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (b) {
				tx.commit();
				System.out.println("records inserted");
			} else {
				tx.rollback();
				System.out.println("records are not inserted");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

	public void loadObject() {
		Query query = ses.createQuery("from Person");

		List<Person> list = query.list();
		list.forEach(l -> {
			System.out.println(l);
			System.out.println(l.getName() + " " + l.getNo());
			Set<Phno> set = l.getSet();
			set.forEach(s -> {
				System.out.println(s);
			});
		});
	}

	public void deleteObject() {
		boolean b=false;
		Person p=ses.get(Person.class, 3);
		System.out.println(p);
		Set<Phno> set = p.getSet();
		System.out.println(set);
		long no=0;
		for(Phno n:set) {
		no=n.getPh1();
		}
		
		Phno ph=ses.get(Phno.class,no);
		System.out.println(ph);
		Transaction tx = null;
		tx = ses.beginTransaction();
		if(ph!=null) {
		try {
			set.remove(ph);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (b) {
				tx.commit();
				System.out.println("records inserted");
			} else {
				tx.rollback();
				System.out.println("records are not inserted");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		}
		else {
			System.out.println("records not found");
		}
	}

}
