package com.github.cartrader.util;

import java.util.Collection;
import java.util.Set;

import com.github.cartrader.entity.Ad;

public class Partition {
	private final Collection<Ad> ads;
	
	public Partition(Collection<Ad> ads) {
		this.ads = ads != null ? ads : Set.of();
	}

	public Collection<Ad> getAds() {
		return ads;
	}
}