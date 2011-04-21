package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	private String country;
	private String city;
	private String person;
	private String phone;
	private String email;
	@OneToMany(mappedBy="owner")
	private List<Listing> listings;
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += country == null ? 1 : country.hashCode();
		hash += city == null ? 1 : city.hashCode();
		hash += person == null ? 1 : person.hashCode();
		hash += phone == null ? 1 : phone.hashCode();
		hash += email == null ? 1 : email.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object e) {
		if (this == e)
			return true;
		if (!(e instanceof Owner))
			return false;
		return e.hashCode() == this.hashCode();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Listing> getListings() {
		return listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}
}
