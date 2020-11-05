package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.cartrader.entity.Ad;

@Repository
public interface AdRepository extends PagingAndSortingRepository<Ad, Long>, JpaSpecificationExecutor<Ad> {

}
