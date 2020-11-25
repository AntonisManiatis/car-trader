package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.SellerType;

public final class SellerTypeSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 4317469496285891670L;
	
	private final SellerType type;
	
	public SellerTypeSpecification(SellerType type) {
		this.type = type;
	}

	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("seller").get("sellerType"), type);
	}
}
