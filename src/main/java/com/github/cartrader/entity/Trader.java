package com.github.cartrader.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Anthony
 */
@Entity
public class Trader {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastname;
	
	private SellerType sellerType = SellerType.UNDEFINED;
	@Embedded
	private ContactInfo contactInfo;
	
	@OneToMany(mappedBy = "trader", cascade = CascadeType.ALL)
	private List<Ad> ads = List.of();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public SellerType getSellerType() {
		return sellerType;
	}

	public void setSellerType(SellerType sellerType) {
		this.sellerType = sellerType;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Ad> getAds() {
		return ads;
	}
	
	public void addAd(Ad ad) {
		ad.setTrader(this);
		this.ads.add(ad);
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}
}
