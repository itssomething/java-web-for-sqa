package net.guides.springboot2.springboot2webappthymeleaf.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Payment {
	private Integer loan_id;
	private Integer user_id;
	private Float money_amount;
	@DateTimeFormat(iso=ISO.DATE)
	private Date pay_date;
	private Integer period_count;
	
	public Integer getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(Integer loan_id) {
		this.loan_id = loan_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Float getMoney_amount() {
		return money_amount;
	}
	public void setMoney_amount(Float money_amount) {
		this.money_amount = money_amount;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public Integer getPeriod_count() {
		return period_count;
	}
	public void setPeriod_count(Integer period_count) {
		this.period_count = period_count;
	}
}
