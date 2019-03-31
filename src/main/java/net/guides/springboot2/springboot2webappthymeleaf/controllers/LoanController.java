package net.guides.springboot2.springboot2webappthymeleaf.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
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
	
	@GetMapping("/loans/new")
	public String showNewLoanForm(Loan loan, Model model) {
//		List<User> users = userRepo.findAll();
		model.addAttribute("users", userRepo.findAll());
		return "loans/new";
	}
	
	@PostMapping("/loans/new")
	public String postNewLoanForm(Loan loan) {
		loan.setRemaining_principal(loan.getAmount_of_money());
		loanRepo.save(loan);
		return "users/index";
	}
	
	@GetMapping("/loans")
	public String indexLoans(Model model, Loan loan) {
		model.addAttribute("loans", loanRepo.findAll());
		return "loans/index";
	}
}
