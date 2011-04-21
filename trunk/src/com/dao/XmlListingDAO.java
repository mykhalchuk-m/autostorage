package com.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.beans.Listing;
import com.beans.Listings;

public class XmlListingDAO {
	private static JAXBContext jaxbContext;
	private static Unmarshaller unmarshaller;
	static {
		try {
			jaxbContext = JAXBContext.newInstance("com.factories");
			unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author mmykhalchuk
	 * @param fileName
	 *            path to file which contains xml-formating data with root
	 *            item listings
	 * @see Listings
	 * @return set of Listing objects if input file has correct file with data
	 *         or null if not
	 * @throws FileNotFoundException
	 * */
	public static Set<Listing> getListings(String fileName)
			throws FileNotFoundException {
		File f = new File(fileName);
		if (!f.exists()) {
			throw new FileNotFoundException(fileName + ": File Not Found");
		}
		try {
			Listings listElements = (Listings) unmarshaller.unmarshal(f);
			return listElements.getListings();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}
