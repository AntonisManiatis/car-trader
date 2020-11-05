package com.github.cartrader.entity;

/**
 * Describes the condition of the car
 * @author Anthony
 */
public enum CarCondition {
	
	/**
	 * Car's condition is undefined yet.
	 */
	UNDEFINED,
	
	/**
	 * Car is brand new, typically sold by a dealer
	 */
	NEW,
	
	/**
	 * Car has been used by one or more other users and typically has mileage on it
	 */
	USED
}
