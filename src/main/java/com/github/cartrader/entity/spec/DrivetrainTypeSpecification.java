package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.DrivetrainType;

public final class DrivetrainTypeSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 8946921577879163437L;
	
	private final DrivetrainType drivetrain;
	
	public DrivetrainTypeSpecification(DrivetrainType drivetrain) {
		this.drivetrain = drivetrain;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("car").get("drivetrain"), drivetrain);
	}
}
