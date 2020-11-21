package com.github.cartrader.entity;

/**
 * https://thorben-janssen.com/fetch-association-of-subclass/ a way to tackle our issue
 * @author Anthony
 *
 */
public enum SellerType {
	
	UNDEFINED,
	
	/**
	 * A dealer is typically a person or a business that sells cars.
	 */
	DEALER,
	
	/**
	 * A private seller could be anyone wanting to sell their car.
	 */
	PRIVATE_SELLER;
}
