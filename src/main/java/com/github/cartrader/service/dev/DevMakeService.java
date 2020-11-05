package com.github.cartrader.service.dev;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Make;
import com.github.cartrader.entity.Model;
import com.github.cartrader.service.MakeService;

@Profile("dev")
@Service
public final class DevMakeService implements MakeService {
	private static final Map<Long, Make> MAKES; 
	
	static {
		MAKES = new HashMap<>();
		var make = new Make();
		make.setName("Mazda");
		var model = new Model();
		model.setId(0);
		model.setName("RX-7");
		make.setModels(Set.of(model));
		
		MAKES.put(0l, make);
		
		make = new Make();
		make.setId(1);
		make.setName("Honda");
		model = new Model();
		model.setId(1);
		model.setName("S2000");
		make.setModels(Set.of(model));
		
		MAKES.put(1l, make);
	}
	
	@Override
	public Collection<Make> findAll() {
		return MAKES.values();
	}
	
	@Override
	public Make findById(long id) {
		return MAKES.get(id);
	}
}
