package com.beans;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Listings {
	private Set<Listing> listing;

	public Set<Listing> getListings() {
		return listing;
	}

	public void setListings(Set<Listing> listing) {
		this.listing = listing;
	}
}
