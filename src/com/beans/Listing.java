package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;


@Entity
@Table(name = "listing")
public class Listing implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "detailslink")
	private String detailsLink;
	private String oldId;
	private String marka;
	private String model;
	private String price;
	@Embedded
	private BasicInformation basicInformation;
	@Column(name = "additionalinfo")
	private String additionalInfo;
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "photos", joinColumns = @JoinColumn(name = "photo_id"))
	private List<String> photos;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_fc")
	private Owner owner;

	@Override
	public int hashCode() {
		int hash = 0;
		hash += detailsLink == null ? 1 : detailsLink.hashCode();
		hash += oldId == null ? 1 : oldId.hashCode();
		hash += marka == null ? 1 : marka.hashCode();
		hash += model == null ? 1 : model.hashCode();
		hash += price == null ? 1 : price.hashCode();
		hash += basicInformation == null ? 1 : basicInformation.hashCode();
		hash += additionalInfo == null ? 1 : additionalInfo.hashCode();
		hash += owner == null ? 1 : owner.hashCode();
		hash *= 31;
		return hash;
	}

	@Override
	public boolean equals(Object e) {
		if (this == e)
			return true;
		if (!(e instanceof Listing))
			return false;
		return e.hashCode() == this.hashCode();
	}
	
	public String toString() {
		return model + " " + marka;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetailsLink() {
		return detailsLink;
	}

	public void setDetailsLink(String detailsLink) {
		this.detailsLink = detailsLink;
	}

	@XmlElement(name = "old.id")
	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@XmlElement(name = "basic.information")
	public BasicInformation getBasicInformation() {
		return basicInformation;
	}

	public void setBasicInformation(BasicInformation basicInformation) {
		this.basicInformation = basicInformation;
	}

	@XmlElement(name = "additional.info")
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@XmlList
	@XmlElement(name="photos")
	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	
	@XmlElement(name = "owner")
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}