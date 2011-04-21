package com.utils;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.BasicInformation;
import com.beans.Listing;
import com.beans.Owner;

public class HibernateUtil {
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactory;

	/**
	 * Constructs a new Singleton SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 * @throws HibernateException
	 */
	public static SessionFactory buildSessionFactory()
			throws HibernateException {
		if (sessionFactory != null) {
			closeFactory();
		}
		return configureSessionFactory();
	}

	/**
	 * Builds a SessionFactory, if it hasn't been already.
	 */
	public static SessionFactory buildIfNeeded() throws HibernateException {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		try {
			return configureSessionFactory();
		} catch (HibernateException e) {
			throw new HibernateException(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() throws HibernateException {
		buildIfNeeded();
		return sessionFactory.openSession();
	}

	public static void closeFactory() {
		if (sessionFactory != null) {
			try {
				sessionFactory.close();
			} catch (HibernateException ignored) {
				logger.info("Couldn't close SessionFactory. " + ignored);
			}
		}
	}

	public static void close(Session session) {
		if (session != null) {
			try {
				session.close();
			} catch (HibernateException ignored) {
				logger.info("Couldn't close Session. " + ignored);
			}
		}
	}

	public static void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (HibernateException ignored) {
			logger.info("Couldn't rollback Transaction. " + ignored);
		}
	}

	/**
	 * Configure the SessionFactory
	 * 
	 * @return SessionFactory
	 * @throws HibernateException
	 */
	private static SessionFactory configureSessionFactory()
			throws HibernateException {
		Configuration conf = new Configuration()
				.addAnnotatedClass(Owner.class)
				.addAnnotatedClass(BasicInformation.class)
				.addAnnotatedClass(Listing.class).configure();
		sessionFactory = conf.buildSessionFactory();
		return sessionFactory;
	}
}
