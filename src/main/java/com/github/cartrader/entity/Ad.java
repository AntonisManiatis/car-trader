package com.github.cartrader.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private AdPurpose purpose = AdPurpose.UNDEFINED;
	private Date publishDate;
	
	// Car condition
	private CarCondition carCondition = CarCondition.UNDEFINED;
	
	// Car related
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="makeId", referencedColumnName="id")
	private Make make;
	
	// Car related
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="categoryId", referencedColumnName="id")
	private Category category;
	// Car related
	private LocalDate modelYear;
	
	@OneToMany
	private List<PictureId> pictures = List.of();
	// Car related
	@OneToMany
	private Set<Feature> features = Set.of();
	
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

	public CarCondition getCondition() {
		return carCondition;
	}

	public void setCondition(CarCondition condition) {
		this.carCondition = condition;
	}

	public AdPurpose getPurpose() {
		return purpose;
	}

	public void setPurpose(AdPurpose purpose) {
		this.purpose = purpose;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
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

	public LocalDate getModelYear() {
		return modelYear;
	}

	public void setModelYear(LocalDate modelYear) {
		this.modelYear = modelYear;
	}

	public List<PictureId> getPictures() {
		return pictures;
	}

	public void setPictures(List<PictureId> pictures) {
		this.pictures = pictures;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}
}
