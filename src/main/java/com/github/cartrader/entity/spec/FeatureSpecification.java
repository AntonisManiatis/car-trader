package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.Car;
import com.github.cartrader.entity.Feature;

/**
 * 
 * @author Anthony
 */
public final class FeatureSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 9111867821418149189L;
	
	private final Feature feature;
	
	public FeatureSpecification(Feature feature) {
		this.feature = feature;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		var carJoin = root.<Feature, Car>join("car");
		var featureJoin = carJoin.join("features");
		return cb.equal(featureJoin.get("id"), feature.getId());
	}
}
