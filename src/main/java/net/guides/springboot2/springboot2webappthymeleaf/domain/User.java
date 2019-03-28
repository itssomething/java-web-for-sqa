package net.guides.springboot2.springboot2webappthymeleaf.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String email;
	private Integer role;
	@OneToMany(mappedBy="user")
	private Set<Loan> loans;
	
	public User() {}

	public User(Integer id, String email, Integer role, Set<Loan> loans) {
		super();
		this.id = id;
		this.email = email;
		this.role = role;
		this.loans = loans;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Set<Loan> getLoan() {
		return loans;
	}

	public void setLoan(Set<Loan> loans) {
		this.loans = loans;
	}
	
	
}
