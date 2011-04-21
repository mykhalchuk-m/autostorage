package com.run;

import java.util.Iterator;
import java.util.Set;

import com.beans.Listing;
import com.dao.ListingDAO;
import com.factories.XmlParser;

public class ListingStorageRunner implements Runnable {
	private final String fileName;

	public ListingStorageRunner(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		XmlParser parser = new XmlParser();
		Set<Listing> listings = parser.runFileParser(fileName);
		if (listings != null) {
			for (Iterator<Listing> iterator = listings.iterator(); iterator
					.hasNext();) {
				Listing listing = iterator.next();
				ListingDAO dao = new ListingDAO();
				dao.save(listing);
			}
		}
	}
}
