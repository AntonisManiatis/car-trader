package com.github.cartrader.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.cartrader.entity.Make;
import com.github.cartrader.entity.Model;
import com.github.cartrader.service.MakeService;

@RestController
public class MakeController {
	private final MakeService makeService;
	
	@Autowired
	public MakeController(MakeService makeService) {
		this.makeService = makeService;
	}
	
	@GetMapping("/makes")
	public Collection<Make> all() {
		return makeService.findAll();
	}
	
	@GetMapping("/makes/{id}")
	public Make get(@PathVariable long id) {
		return makeService.findById(id);
	}
	
	@GetMapping("/makes/{makeId}/models")
	public Collection<Model> models(@PathVariable long makeId) {
		var make = makeService.findById(makeId);
		return make.getModels();
	}
}
