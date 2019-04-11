package com.nt.dao;

import java.util.ArrayList;
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
		List<Phno> list = new ArrayList();
		Phno ph = new Phno();
		ph.setPh1(8985977348L);
		ph.setType("personal");

		Phno ph1 = new Phno();
		ph1.setPh1(9052153355L);
		ph1.setType("others");

		list.add(ph);
		list.add(ph1);

		Person p = new Person();
		p.setName("vbv");
		p.setList(list);
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
		Query query = ses.createQuery("from Person where no=6");

		List<Person> list = query.list();
		list.forEach(l -> {
			System.out.println(l);
			List<Phno> list1 = l.getList();
			list1.forEach(s -> {
				System.out.println(s);
			});
		});
	}

	public void deleteObject() {
		boolean b=false;
		Person p=ses.get(Person.class, 3);
		System.out.println(p);
		List<Phno> list = p.getList();
		System.out.println(list);
		long no=0;
		for(Phno n:list) {
		no=n.getPh1();
		}
		
		Phno ph=ses.get(Phno.class,no);
		System.out.println(ph);
		Transaction tx = null;
		tx = ses.beginTransaction();
		if(ph!=null) {
		try {
			list.remove(ph);
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
