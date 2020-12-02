package com.github.cartrader.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import com.github.cartrader.entity.AdPurpose;
import com.github.cartrader.entity.CarCondition;
import com.github.cartrader.entity.Category;
import com.github.cartrader.entity.Feature;

public class AdSubmission {
	@NotNull
	private CarCondition condition;
	@NotNull
	private AdPurpose purpose;
	@NotNull
	private Category category;
	
	private Set<Feature> features = Set.of();

	public CarCondition getCondition() {
		return condition;
	}

	public void setCondition(CarCondition condition) {
		this.condition = condition;
	}

	public AdPurpose getPurpose() {
		return purpose;
	}

	public void setPurpose(AdPurpose purpose) {
		this.purpose = purpose;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeature(Set<Feature> features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "AdSubmission [condition=" + condition + ", purpose=" + purpose + ", category=" + category
				+ ", features=" + features + "]";
	}
}
