package net.guides.springboot2.springboot2webappthymeleaf.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;
import service.PaymentProcessService;
import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.Payment;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.LoanRepository;

@Controller
public class PaymentController {
	@Autowired
	LoanRepository loanRepo;
	
	@GetMapping("/payments/new")
	public String processPayment(@RequestParam Integer loan_id, Float money_amount, Date pay_date, Model model) {
		Payment payment = new Payment();
		payment.setLoan_id(loan_id);
		
		payment.setPay_date(pay_date);
		
		Optional<Loan> temp = loanRepo.findById(loan_id);
		Loan loan = new Loan();
		loan = temp.get();
		
		
		
		model.addAttribute("payment", payment);
		model.addAttribute("loan", loan);
		return "payments/new";
	}
	
	@PostMapping("/payments/new")
	public String postProcessPayment(Payment payment, Model model) {
		System.out.print(payment.getMoney_amount());
		
		Optional<Loan> temp = loanRepo.findById(payment.getLoan_id());
		Loan loan = new Loan();
		loan = temp.get();
//		loan.setRemaining_principal(loan.getAmount_of_money() - payment.getMoney_amount());
//		loanRepo.save(loan);
	    PaymentProcessService pps = new PaymentProcessService(loanRepo, loan, payment);
	    pps.processPayment(loan, payment);
		return "done";
	}
}
