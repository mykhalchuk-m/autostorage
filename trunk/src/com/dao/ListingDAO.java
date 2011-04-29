package com.dao;

import java.util.List;

import org.hibernate.Query;

import com.beans.Listing;
import com.beans.Owner;

public class ListingDAO extends AbstractDAO<Listing> {
	private static String EQUAL_LISTING_QUERY = "select l.id from owner as o inner join listing as l on l.owner_fc=o.id where l.marka=:marka and l.model=:model and l.year=:year";

	public ListingDAO() {
		super();
	}

	@Override
	public void save(Listing listing) {
		listing.setAdditionalInfo(removeWhiteSpace(listing.getAdditionalInfo()));
		if (!isEqualsInDB(listing)) {
			OwnerDAO ownerDAO = new OwnerDAO();
			Owner dbOwner = listing.getOwner();
			Owner owner = ownerDAO.getOwnerByParams(session, dbOwner.getPerson(),
					dbOwner.getCountry(), dbOwner.getCity(),
					dbOwner.getPhone(), dbOwner.getEmail());
			if (owner != null) {
				List<Listing> listings = owner.getListings();
				listings.add(listing);
				owner.setListings(listings);
				ownerDAO.update(owner);
				listing.getOwner().setId(owner.getId());
			}
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
		boolean exist = false;
		Query query = session.createSQLQuery(buildQuery(listing.getOwner()));
		query.setString("marka", listing.getMarka());
		query.setString("model", listing.getModel());
		query.setString("year", listing.getBasicInformation().getYear());
		List<?> list = query.list();
		if (list.size() > 0) {
			exist = true;
		} else {
			exist = false;
		}
		logger.info("Existing item " + listing.getMarka() + " "
				+ listing.getModel() + " in data base: " + exist);
		return exist;
	}

	private String buildQuery(Owner owner) {
		StringBuilder builder = new StringBuilder();
		builder.append(EQUAL_LISTING_QUERY);
		if (owner.getCity() == "") {
			builder.append(" and o.city=" + owner.getCity());
		}
		if (owner.getCity() == "") {
			builder.append(" and o.person=" + owner.getPerson());
		}
		if (owner.getCity() == "") {
			builder.append(" and o.email=l" + owner.getEmail());
		}
		return builder.toString();
	}
}
