package net.guides.springboot2.springboot2webappthymeleaf.controllers;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;

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
		payment.setMoney_amount(money_amount);
		payment.setPay_date(pay_date);
		
		model.addAttribute("payment", payment);
		return "payments/new";
	}
	
//	@GetMapping("/payments/new")
//	public String processPayment(Payment payment, Model model) {
//		
//		model.addAttribute("payment", payment);
//		return "payments/new";
//	}
}
