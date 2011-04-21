package com.factories;

import java.io.File;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.beans.Listing;
import com.beans.Listings;

public class XmlParser {
	private Logger logger = Logger.getLogger(XmlParser.class);
	public Set<Listing> runFileParser(String fileName) {
		Listings elements = null;
		try {
			logger.info("Strated parsing, file " + fileName);
			JAXBContext jc = JAXBContext.newInstance("com.factories");
			Unmarshaller u = jc.createUnmarshaller();
			File f = new File(fileName);
			elements = (Listings) u.unmarshal(f);
			logger.info("Parsing compleated, file " + fileName);
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
		}
		if (elements instanceof Listings) {
			return elements.getListings();
		}
		return null;
	}	
}
