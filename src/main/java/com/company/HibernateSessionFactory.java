package com.company;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static Session currentSession() throws HibernateException {
        if (sessionFactory == null) {
            try {
                sessionFactory = XmlConfig();
            } catch (Exception e) {
                System.err.println("Error Creating SessionFactory");
                e.printStackTrace();
            }
        }
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) throws HibernateException {
        if (session != null) {
            session.close();
        }
    }

    public static SessionFactory XmlConfig() {
        return new Configuration().configure().buildSessionFactory();
    }
}

