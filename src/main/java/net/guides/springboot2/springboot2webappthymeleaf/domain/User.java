package net.guides.springboot2.springboot2webappthymeleaf.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String email;
	private Integer role;
	@OneToMany(mappedBy="user")
	private Set<Loan> loan;
	
	public User() {}

	public User(Integer id, String email, Integer role, Set<Loan> loan) {
		super();
		this.id = id;
		this.email = email;
		this.role = role;
		this.loan = loan;
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
		return loan;
	}

	public void setLoan(Set<Loan> loan) {
		this.loan = loan;
	}
	
	
}
