package com.github.cartrader.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.github.cartrader.entity.Ad;

public class PagePartitioner {
	private final Page<Ad> page;
	private final int chunkSize;
	
	public PagePartitioner(Page<Ad> page, int chunkSize) {
		this.page = page;
		this.chunkSize = chunkSize;
	}
	
	public PagePartitioner(Page<Ad> page) {
		this(page, 4);
	}
	
	public List<Partition> createPartitions() {
		var content = page.getContent();
		var partitions = new ArrayList<Partition>();
		for (var i = 0; i < content.size(); i += chunkSize) {
		    int end = Math.min(i + chunkSize, content.size());
		    partitions.add(new Partition(content.subList(i, end)));
		}
		
		return partitions;
	}
}