package net.guides.springboot2.springboot2webappthymeleaf.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.LoanRepository;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;

@Controller
public class LoanController {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	LoanRepository loanRepo;
	
	@GetMapping("/users/{userId}/loans")
	public String getAllLoansByUserId(Model model, @PathVariable (value = "userId") int userId) {
		model.addAttribute("loans", loanRepo.findByUserId(userId));
		return "loans/show";
	}
	
	@GetMapping("/loans/{loanId}")
	public String showLoan(@PathVariable("loanId") int loanId, Model model) {
//		LoanRepository loanRepo = null;
		Optional<Loan> tempLoan = loanRepo.findById(loanId);
		Loan loan = tempLoan.get();
		model.addAttribute("loan", loan);		
		return "loans/show";
	}
}
