package net.guides.springboot2.springboot2webappthymeleaf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User
{
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String email;
	
	public User()
	{
	}

	public User(Integer id, String email)
	{
		this.id = id;
		this.email = email;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
}
