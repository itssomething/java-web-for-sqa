package net.guides.springboot2.springboot2webappthymeleaf.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.User;

public interface LoanRepository extends CrudRepository<Loan, Integer>{
	
	public List<Loan> findByUserId(int userId);
}
