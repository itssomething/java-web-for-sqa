package net.guides.springboot2.springboot2webappthymeleaf.domain;

import java.sql.Date;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer user_id;
	private Integer type;
	private float current_interest_rate;
	private float amount_of_money;
	private Integer number_of_period;
	private Integer lending_time;
	private Date time_of_disbursement;
	private float remaining_principal;
	private Integer period_count;
	
	@ManyToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private User user;
	
	public Loan() {}
	
	public String getStringAmountOfMoney() {
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(12);
		
		return df.format(amount_of_money);
	}
	
	public String getStringRemainingPrincipal() {
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(12);
		
		return df.format(remaining_principal);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public float getCurrent_interest_rate() {
		return current_interest_rate;
	}

	public void setCurrent_interest_rate(float current_interest_rate) {
		this.current_interest_rate = current_interest_rate;
	}

	public float getAmount_of_money() {
		return amount_of_money;
	}

	public void setAmount_of_money(float amount_of_money) {
		this.amount_of_money = amount_of_money;
	}

	public Integer getNumber_of_period() {
		return number_of_period;
	}

	public void setNumber_of_period(Integer number_of_period) {
		this.number_of_period = number_of_period;
	}

	public Integer getLending_time() {
		return lending_time;
	}

	public void setLending_time(Integer lending_time) {
		this.lending_time = lending_time;
	}

	public Date getTime_of_disbursement() {
		return time_of_disbursement;
	}

	public void setTime_of_disbursement(Date time_of_disbursement) {
		this.time_of_disbursement = time_of_disbursement;
	}

	public float getRemaining_principal() {
		return remaining_principal;
	}

	public void setRemaining_principal(float remaining_principal) {
		this.remaining_principal = remaining_principal;
	}

	public Integer getPeriod_count() {
		return period_count;
	}

	public void setPeriod_count(Integer period_count) {
		this.period_count = period_count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
