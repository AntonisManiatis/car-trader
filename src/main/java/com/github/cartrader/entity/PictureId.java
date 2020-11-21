package com.github.cartrader.entity;

import javax.persistence.Embeddable;

@Embeddable
public class PictureId {
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
