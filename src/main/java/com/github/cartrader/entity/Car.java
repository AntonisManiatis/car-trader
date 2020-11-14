package com.github.cartrader.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Embeddable
public class Car {
	private CarCondition carCondition = CarCondition.UNDEFINED;
	
	@OneToOne
	@JoinColumn(name="makeId", referencedColumnName="id")
	private Make make;
	@OneToOne
	@JoinColumn(name="modelId", referencedColumnName="id")
	private Model model;
	@OneToOne
	@JoinColumn(name="categoryId", referencedColumnName="id")
	private Category category;
	
	@Embedded
	private EngineDetails engineDetails;
	private DrivetrainType drivetrain = DrivetrainType.UNDEFINED;
	private TransmissionType transmition = TransmissionType.UNDEFINED;
	
	private LocalDate modelYear;
	private int mileage;
	
	@OneToMany
	private Set<Feature> features = Set.of();
	
	private int doors;
	private int sits;
	
	public CarCondition getCondition() {
		return carCondition;
	}
	
	public void setCarCondition(CarCondition condition) {
		this.carCondition = condition;
	}

	public EngineDetails getEngineDetails() {
		return engineDetails;
	}

	public void setEngineDetails(EngineDetails engineDetails) {
		this.engineDetails = engineDetails;
	}

	public DrivetrainType getDrivetrain() {
		return drivetrain;
	}

	public void setDrivetrain(DrivetrainType drivetrain) {
		this.drivetrain = drivetrain;
	}

	public TransmissionType getTransmition() {
		return transmition;
	}

	public void setTransmition(TransmissionType transmition) {
		this.transmition = transmition;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getModelYear() {
		return modelYear;
	}

	public void setModelYear(LocalDate modelYear) {
		this.modelYear = modelYear;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getSits() {
		return sits;
	}

	public void setSits(int sits) {
		this.sits = sits;
	}
}
