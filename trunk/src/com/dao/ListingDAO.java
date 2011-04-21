package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.beans.Listing;

public class ListingDAO extends AbstractDAO<Listing> {

	public ListingDAO() {
		super();
	}

	@Override
	public void save(Listing listing) {
		listing.setAdditionalInfo(removeWhiteSpace(listing.getAdditionalInfo()));
		// OwnerDAO ownerDAO = new OwnerDAO();
		// Owner dbOwner = ownerDAO.getOwnerByParams(listing.getOwner()
		// .getPerson(), listing.getOwner().getCountry(), listing
		// .getOwner().getCity(), listing.getOwner().getPhone(), listing
		// .getOwner().getEmail());
		if (!isEqualsInDB(listing)) {
			super.save(listing);
		}
	}

	@Override
	public void update(Listing listing) {
		super.update(listing);
	}

	public Listing getElementById(Class<Listing> itemClass, long id) {
		Listing listing = super.getElementById(itemClass, id);
		return listing;
	}

	private String removeWhiteSpace(String line) {
		String result = "";
		if (line != null || line != "") {
			result = line.replaceAll("\t+", "");
			result = result.replace('\n', ' ');
		}
		return result;
	}

	private boolean isEqualsInDB(Listing listing) {
		super.startOperation();
		Criteria criteria = session.createCriteria(Listing.class);
		if (listing.getMarka() != null) {
			criteria.add(Restrictions.eq("marka", listing.getMarka()));
		}
		if (listing.getModel() != null) {
			criteria.add(Restrictions.eq("model", listing.getModel()));
		}
		if (listing.getBasicInformation().getYear() != null) {
			criteria.add(Restrictions.eq("year", listing.getBasicInformation()
					.getYear()));
		}
		if (listing.getOwner().getCity() != null) {
			criteria.add(Restrictions.eq("city", listing.getOwner().getCity()));
		}
		if (listing.getOwner().getEmail() != null) {
			criteria.add(Restrictions
					.eq("email", listing.getOwner().getEmail()));
		}
		@SuppressWarnings("unchecked")
		List<Listing> existList = criteria.list();
		if (existList.size() > 0) {
			return true;
		}
		return false;
	}
}
