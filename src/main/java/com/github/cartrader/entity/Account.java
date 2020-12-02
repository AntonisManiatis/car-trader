package com.github.cartrader.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trader_id", referencedColumnName = "id")
	private Trader trader;
	
	public Account(String email, String password) {
		this.email = email;
		this.passsword = password;
		this.trader = new Trader();
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

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}
}
