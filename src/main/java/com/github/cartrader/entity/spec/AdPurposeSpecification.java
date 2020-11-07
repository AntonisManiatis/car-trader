package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.AdPurpose;

public final class AdPurposeSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 9014537535439721948L;
	
	private final AdPurpose purpose;
	
	public AdPurposeSpecification(AdPurpose purpose) {
		this.purpose = purpose != null ? purpose : AdPurpose.UNDEFINED;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("purpose"), purpose);
	}
}
