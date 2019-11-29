package com.company.dao;

import com.company.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class ElementDAOImpl<E> implements ElementDAO<E> {

    private Class<E> elementClass;

    public ElementDAOImpl(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public void addElement(E element) {
        Session session = null;
        try {
            session = HibernateSessionFactory.currentSession();
            Transaction transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                HibernateSessionFactory.closeSession(session);
            }
        }
    }

    public void updateElement(E element) {
        Session session = null;
        try {
            session = HibernateSessionFactory.currentSession();
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                HibernateSessionFactory.closeSession(session);
            }
        }
    }

    public E getElementByID(int elementId) {
        Session session = null;
        E element = null;
        try {
            session = HibernateSessionFactory.currentSession();
            element = (E) session.get(elementClass, elementId);
        } finally {
            if ((session != null) && (session.isOpen())) {
                HibernateSessionFactory.closeSession(session);
            }
        }
        return element;
    }

    public List<E> getAllElements() {
        Session session = null;
        List<E> elements = new ArrayList<E>();
        try {
            session = HibernateSessionFactory.currentSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<E> criteria = builder.createQuery(elementClass);
            Root<E> elementRoot = criteria.from(elementClass);
            criteria.select(elementRoot);
            elements = session.createQuery(criteria).getResultList();
        } finally {
            if ((session != null) && (session.isOpen())) {
                HibernateSessionFactory.closeSession(session);
            }
        }
        return elements;
    }

    public void deleteElement(E element) {
        Session session = null;
        try {
            session = HibernateSessionFactory.currentSession();
            Transaction transaction = session.beginTransaction();
            session.delete(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                HibernateSessionFactory.closeSession(session);
            }
        }
    }
}
