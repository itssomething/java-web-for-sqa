package net.guides.springboot2.springboot2webappthymeleaf.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer>{
	
	public List<Loan> findByUserId(int userId);
	public Loan findFirstByOrderByIdDesc();
	
//	@Query("select u from User u where u.emailAddress = ?1")
	@Transactional
	@Modifying
	@Query(value = "update Loan l set l.remaining_principal= ?1 where l.id= ?2")
	public void updateRemainingPrincipalById(Float amount, int id);
}
