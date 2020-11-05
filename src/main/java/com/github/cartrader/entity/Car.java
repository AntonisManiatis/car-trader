package com.github.cartrader.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Car {
	private CarCondition carCondition = CarCondition.UNDEFINED;
	private EngineDetails details;
	private DrivetrainType drivetrain = DrivetrainType.UNDEFINED;
	private TransmissionType transmition = TransmissionType.UNDEFINED;
	
	private int doors;
	private int sits;
}
