package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;

	static {
		Configuration cfg = null;
		cfg = new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		Session ses = factory.openSession();
		return ses;
	}

	public static void closeSession(Session ses) {
		if (ses != null)
			ses.close();
	}

	public static void closeSessionFactory() {
		if (factory != null)
			factory.close();
	}

}
