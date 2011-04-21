package com.beans;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
@Access(AccessType.PROPERTY)
public class BasicInformation implements Serializable {
	private static final long serialVersionUID = 1L;
	private String year;
	private int running;
	private String carcass;
	private String color;
	private String motorType;
	private String motorVolume;
	private String gearbox;
	private String transmission;
	private String rudder;
	private String customs;
	private String state;

	@Override
	public int hashCode() {
		int hash = 0;
		hash += year == null ? 1 : year.hashCode();
		hash += carcass == null ? 1 : carcass.hashCode();
		hash += color == null ? 1 : color.hashCode();
		hash += motorType == null ? 1 : motorType.hashCode();
		hash += motorVolume == null ? 1 : motorVolume.hashCode();
		hash += gearbox == null ? 1 : gearbox.hashCode();
		hash += transmission == null ? 1 : transmission.hashCode();
		hash += rudder == null ? 1 : rudder.hashCode();
		hash += customs == null ? 1 : customs.hashCode();
		hash += state == null ? 1 : state.hashCode();
		return hash == 0 ? 1 : 31 * hash;
	}

	@Override
	public boolean equals(Object e) {
		if (this == e)
			return true;
		if (!(e instanceof BasicInformation))
			return false;
		return e.hashCode() == this.hashCode();
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getRunning() {
		return running;
	}

	public void setRunning(int running) {
		this.running = running;
	}

	public String getCarcass() {
		return carcass;
	}

	public void setCarcass(String carcass) {
		this.carcass = carcass;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@XmlElement(name="motor.type")
	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	@XmlElement(name="motor.volume")
	public String getMotorVolume() {
		return motorVolume;
	}

	public void setMotorVolume(String motorVolume) {
		this.motorVolume = motorVolume;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getRudder() {
		return rudder;
	}

	public void setRudder(String rudder) {
		this.rudder = rudder;
	}

	public String getCustoms() {
		return customs;
	}

	public void setCustoms(String customs) {
		this.customs = customs;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
