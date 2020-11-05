package com.github.cartrader.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.cartrader.service.AdService;
import com.github.cartrader.util.PagePartitioner;

@Controller
public class IndexController {
	private final AdService adService;
	
	public IndexController(AdService adService) {
		this.adService = adService;
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		// TODO: Spec of latest ads, add once the spec is implemented
		var page = adService.findAll(null, PageRequest.of(0, 12));
		var view = new ModelAndView("index");
		
		var partitioner = new PagePartitioner(page);
		view.addObject("page", page);
		view.addObject("partitions", partitioner.createPartitions());
		return view;
	}
}
