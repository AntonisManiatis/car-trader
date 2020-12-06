package com.github.cartrader.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

/**
 * 
 * @author Anthony
 */
@Embeddable
public class ContactInfo {
	private String country;
	private String address;
	@ElementCollection
	private List<String> telephones;
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getTelephones() {
		return telephones;
	}
	
	public void setTelephones(List<String> telephones) {
		this.telephones = telephones;
	}
}
