package com.bootdo.wall.domain;


import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Wall {
	
    private  String  userName;
	private  String  sale;
	private  Date  time;
	private  Integer  counts;
	private  Float    money;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}
}
