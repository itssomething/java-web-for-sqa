package net.guides.springboot2.springboot2webappthymeleaf.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.LoanRepository;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;
import service.LoanService;

@Controller
public class LoanController {
	LoanService loanService = new LoanService();
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
		loan.setPeriod_count(0);
		Optional<User> user_temp = userRepo.findById(loan.getUser_id());
		User user = user_temp.get();
		LoanService loan_service = new LoanService(loan, user, userRepo);
		if(loan_service.loanCreatable()) {
			loanRepo.save(loan);
		}
		return "users/index";
	}
	
	@GetMapping("/loans")
	public String indexLoans(Model model, Loan loan) {
		model.addAttribute("loans", loanRepo.findAll());
		return "loans/index";
	}
	
	@GetMapping("/loans/{id}/edit")
	public String showupdateLoan(@PathVariable("id") int id, Model model) {
	    Loan loan = loanRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	    model.addAttribute("loan", loan);
	    return "loans/edit";
	}
	
	@PostMapping("/loans/{id}/update")
	@ResponseStatus(value=HttpStatus.OK)
	public String updateLoan(@PathVariable("id") int id, @Valid Loan loan, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	loan.setId(id);
	        return "loans/edit";
	    }
	    
	    System.out.println(loan.getTime_of_disbursement());
	    loanRepo.save(loan);
	    model.addAttribute("loans", loanRepo.findAll());
	    return "loans/index";
	}
}
