package com.github.cartrader.entity;

import javax.persistence.Embeddable;

@Embeddable
public class EngineDetails {
	private int size;
	private int bhp;
	private int torque;
	private FuelType fuelType = FuelType.UNDEFINED;

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
}
