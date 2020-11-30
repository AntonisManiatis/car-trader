package com.github.cartrader.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Contains Account specific info for each user.
 * @author Anthony
 */
@Entity
public class Account {
	@Id
	private String email;
	@Column(nullable = false)
	private String passsword;
	
	public Account(String email, String password) {
		this.email = email;
		this.passsword = password;
	}
	
	public Account() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasssword() {
		return passsword;
	}
	
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
}
