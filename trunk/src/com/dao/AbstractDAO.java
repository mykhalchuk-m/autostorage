package com.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtil;

public abstract class AbstractDAO<T> {
	protected Logger logger = Logger.getLogger(AbstractDAO.class);
	protected Session session;
	protected Transaction transaction;

	public AbstractDAO() {
		HibernateUtil.buildIfNeeded();
	}
	
	public void save(T t) {
		try {
			logger.info("Start saving " + t.toString());
			startOperation();
			session.save(t);
			transaction.commit();
			logger.info("Saving conpleated " + t.toString());
		} catch (HibernateException e) {
			HibernateUtil.rollback(transaction);
			logger.error(e);
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}

	public void update(T t) {
		try {
			startOperation();
			session.update(t);
			transaction.commit();
		} catch (HibernateException e) {
			HibernateUtil.rollback(transaction);
		} finally {
			HibernateUtil.close(session);
		}
	}

	@SuppressWarnings("unchecked")
	public T getElementById(Class<T> itemClass, long id) {
		T t = null;
		try {
			startOperation();
			t = (T) session.load(itemClass, id);
			transaction.commit();
		} catch (HibernateException e) {
			HibernateUtil.rollback(transaction);
		} finally {
			HibernateUtil.close(session);
		}
		return t;
	}
	
	protected void startOperation() {
		session = HibernateUtil.openSession();
		transaction = session.beginTransaction();
	}
}
