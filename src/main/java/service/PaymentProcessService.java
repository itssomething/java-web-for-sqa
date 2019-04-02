package service;

import org.springframework.beans.factory.annotation.Autowired;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.Payment;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.LoanRepository;

public class PaymentProcessService {
	LoanRepository loanRepo;
	Loan loan;
	Payment payment;
	
	public PaymentProcessService() {
	}
	
	public PaymentProcessService(LoanRepository loanRepo, Loan loan, Payment payment) {
		super();
		this.loanRepo = loanRepo;
		this.loan = loan;
		this.payment = payment;
	}

	public void processPayment(Loan loan, Payment payment) {
		loan.setRemaining_principal(loan.getAmount_of_money() - payment.getMoney_amount());
		loanRepo.save(loan);
	}

//	public void processPayment(Loan loan2, Payment payment2) {
//		loan.setRemaining_principal(loan.getAmount_of_money() - payment.getMoney_amount());
//		loanRepo.save(loan);
//	}
}
