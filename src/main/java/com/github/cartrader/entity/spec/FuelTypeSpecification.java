package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.FuelType;

public final class FuelTypeSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 3966386962555063918L;
	
	private final FuelType fuelType;
	
	public FuelTypeSpecification(FuelType fuelType) {
		this.fuelType = fuelType != null ? fuelType : FuelType.UNDEFINED;
	}

	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("car").get("fuelType"), fuelType);
	}
}
