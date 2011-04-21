package com.factories;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.beans.Listings;

@XmlRegistry
public class ObjectFactory {
	private final static QName _Listings_QNAME = new QName("", "listings");

	@XmlElementDecl(namespace = "", name = "Listings")
	public JAXBElement<Listings> createTest(Listings value) {
		return new JAXBElement<Listings>(_Listings_QNAME, Listings.class, null, value);
	}
}