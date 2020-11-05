package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;

public final class MaxEngineSizeSpecification implements Specification<Ad> {
	private static final long serialVersionUID = -4134723544752018745L;
	
	private final int engineSize;
	
	public MaxEngineSizeSpecification(int engineSize) {
		this.engineSize = engineSize;
	}

	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.lessThanOrEqualTo(root.get("engineSize"), engineSize);
	}
}
