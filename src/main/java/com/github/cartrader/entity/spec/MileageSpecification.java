package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;

public final class MileageSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 1899530657654037858L;
	
	private final int mileage;
	
	public MileageSpecification(int mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.lessThanOrEqualTo(root.get("mileage"), mileage);
	}
}
