package com.github.cartrader.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private AdPurpose purpose = AdPurpose.UNDEFINED;
	
	@CreationTimestamp
	private Date publishDate;
	
	@Embedded
	private Car car;
	
	@ElementCollection
	private List<PictureId> pictures = List.of();
	@ManyToOne
	private Trader trader;
	
	/**
	 * Usually currency is represented as a {@link BigDecimal} but for
	 * our purposes {@code long} should suffice.
	 */
	private long price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AdPurpose getPurpose() {
		return purpose;
	}

	public void setPurpose(AdPurpose purpose) {
		this.purpose = purpose;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date bearable) {
		this.publishDate = bearable;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public List<PictureId> getPictures() {
		return pictures;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setPictures(List<PictureId> pictures) {
		this.pictures = pictures;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
}
