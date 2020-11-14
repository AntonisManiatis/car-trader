package com.github.cartrader.entity;

import javax.persistence.Embeddable;

/**
 * Contains engine specific details about a {@link Car} such as engine size, fuel type, consumption etc.
 * @author Anthony
 */
@Embeddable
public class EngineDetails {
	private int size;
	private int bhp;
	private int torque;
	private FuelType fuelType = FuelType.UNDEFINED;
	
	private float consumptionCity;
	private float consumptionHighway;
	private float consumptionCombined;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getBhp() {
		return bhp;
	}

	public void setBhp(int bhp) {
		this.bhp = bhp;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public float getConsumptionCity() {
		return consumptionCity;
	}

	public void setConsumptionCity(float consumptionCity) {
		this.consumptionCity = consumptionCity;
	}

	public float getConsumptionHighway() {
		return consumptionHighway;
	}

	public void setConsumptionHighway(float consumptionHighway) {
		this.consumptionHighway = consumptionHighway;
	}

	public float getConsumptionCombined() {
		return consumptionCombined;
	}

	public void setConsumptionCombined(float consumptionCombined) {
		this.consumptionCombined = consumptionCombined;
	}
}
