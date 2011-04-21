package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.beans.Owner;

public class OwnerDAO extends AbstractDAO<Owner>{
	
	@Override
	public void save(Owner owner){
		super.save(owner);		
	}
	
	@Override
	public void update(Owner owner){
		super.update(owner);		
	}
	
	@Override
	public Owner getElementById(Class<Owner> ownerClass, long id){
		Owner owner = super.getElementById(ownerClass, id);
		return owner;
	}
	
	public Owner getOwnerByParams(String person, String country, String city, String phone, String email){
		super.startOperation();
		Owner dbOwner = null;
		Criteria criteria = session.createCriteria(Owner.class);
		if (person != ""){
			criteria.add(Restrictions.eq("person", person));
		}
		if (country != ""){
			criteria.add(Restrictions.eq("country", country));
		}
		if (city != ""){
			criteria.add(Restrictions.eq("city", city));
		}
		if (phone != ""){
			criteria.add(Restrictions.eq("phone", phone));
		}
		if (email != ""){
			criteria.add(Restrictions.eq("email", email));
		}
		@SuppressWarnings("unchecked")
		List<Owner> resultList = criteria.list();
		if (resultList.size() != 0) {
			dbOwner = resultList.get(0);
		}
		return dbOwner;
	}
}
