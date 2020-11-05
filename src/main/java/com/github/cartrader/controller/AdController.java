package com.github.cartrader.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.github.cartrader.model.Criteria;
import com.github.cartrader.service.AdService;
import com.github.cartrader.util.PagePartitioner;

// Examples of Specification.
// https://blog.tratif.com/2017/11/23/effective-restful-search-api-in-spring/
// https://attacomsian.com/blog/spring-data-jpa-specifications
// https://www.logicbig.com/tutorials/spring-framework/spring-data/specifications.html
@Controller
public class AdController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdController.class);
	
	private final AdService adService;
	
	@Autowired
	public AdController(AdService adService) {
		this.adService = adService;
	}
	
	@GetMapping("/ads")
	public ModelAndView all(Criteria criteria, Pageable pageable) {
		LOGGER.debug("{}", pageable);
		LOGGER.debug("{}", criteria);
		
		var page = adService.findAll(criteria.spec(), pageable);
		var partitioner = new PagePartitioner(page);
		
		var mv = new ModelAndView("ads");
		mv.addObject("partitions", partitioner.createPartitions());
		mv.addObject("page", page);
		mv.addObject(criteria);
		return mv;
	}
	
	@GetMapping("/ads/{id}") 
	public ModelAndView findById(@PathVariable long id) {
		var mv = new ModelAndView("details");
		var optional = adService.findById(id);
		optional.ifPresent(mv::addObject);
		return mv;
	}
	
	@GetMapping("/ads/search")
	public ModelAndView search(Criteria criteria) {
		return new ModelAndView("search").addObject(criteria);
	}
	
	@GetMapping("/ads/create")
	public ModelAndView create() {
		return new ModelAndView("create");
	}
}
