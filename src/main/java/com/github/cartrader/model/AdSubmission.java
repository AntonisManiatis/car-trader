package com.github.cartrader.model;

import javax.validation.constraints.NotNull;

import com.github.cartrader.entity.CarCondition;

public class AdSubmission {
	@NotNull
	private CarCondition condition;

	public CarCondition getCondition() {
		return condition;
	}

	public void setCondition(CarCondition condition) {
		this.condition = condition;
	}
}
