package org.obeonetwork.fwk.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create SessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new RuntimeException("Configuration problem : " + ex.getMessage(), ex);
        }
    }

    public static final ThreadLocal<Session> sessionTL = new ThreadLocal<Session>();

    public static Session currentSession() throws HibernateException {
        Session s = sessionTL.get();
        // Open a new session if this thread hasn't already one
        if (s == null) {
            s = sessionFactory.openSession();
			sessionTL.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = sessionTL.get();
        if (s != null){
            s.close();
        }
        sessionTL.set(null);
    }
}
