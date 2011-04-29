package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.beans.Owner;

public class OwnerDAO extends AbstractDAO<Owner> {

	@Override
	public void save(Owner owner) {
		super.save(owner);
	}

	@Override
	public void update(Owner owner) {
		super.update(owner);
	}

	@Override
	public Owner getElementById(Class<Owner> ownerClass, long id) {
		Owner owner = super.getElementById(ownerClass, id);
		return owner;
	}

	public Owner getOwnerByParams(Session session, String person,
			String country, String city, String phone, String email) {
		if (session == null) {
			super.startOperation();
		} else {
			transaction = session.beginTransaction();
		}
		Owner dbOwner = null;
		Criteria criteria = session.createCriteria(Owner.class);
		if (person != null) {
			criteria.add(Restrictions.eq("person", person));
		} else {
			criteria.add(Restrictions.isNull("person"));
		}
		if (country != null) {
			criteria.add(Restrictions.eq("country", country));
		} else {
			criteria.add(Restrictions.isNull("country"));
		}
		if (city != null) {
			criteria.add(Restrictions.eq("city", city));
		} else {
			criteria.add(Restrictions.isNull("city"));
		}
		if (phone != null) {
			criteria.add(Restrictions.eq("phone", phone));
		} else {
			criteria.add(Restrictions.isNull("phone"));
		}
		if (email != null) {
			criteria.add(Restrictions.eq("email", email));
		} else {
			criteria.add(Restrictions.isNull("email"));
		}
		@SuppressWarnings("unchecked")
		List<Owner> resultList = criteria.list();
		if (resultList.size() != 0) {
			dbOwner = resultList.get(0);
		}
		return dbOwner;
	}
}
