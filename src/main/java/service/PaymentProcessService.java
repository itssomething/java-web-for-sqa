package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

	public boolean processPayment(Loan loan, Payment payment) {
		
		Double loan_money_amount = (double) loan.getAmount_of_money();
		Double num_of_period = (double) loan.getNumber_of_period();
		Double remain_principal = (double) loan.getRemaining_principal();
		Double rate = (double) loan.getCurrent_interest_rate();
		Double must_pay = loan_money_amount/num_of_period + remain_principal*rate*30/360;

		Double pay_amount = payment.getMoney_amount();
		
		if(pay_amount > must_pay) {
			loan.setRemaining_principal(remain_principal - loan_money_amount/num_of_period);
			Double extra = pay_amount - must_pay;
			loan.setRemaining_principal(loan.getRemaining_principal() - extra);
		}
		else if(pay_amount == must_pay) {
			loan.setRemaining_principal(remain_principal - loan_money_amount/num_of_period);
		}
		
//		loan.setRemaining_principal(loan.getRemaining_principal() - payment.getMoney_amount());
		
		// logic for add number of days to time_of_disbursement
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date   date = null;
//		try {
//			  date   = format.parse(format.format(payment.getPay_date()));
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}   
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		cal.add(Calendar.MONTH, 1);
//		SimpleDateFormat sf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String _strDate= sf.format(cal.getTime());
//		Date date1 = null;
//		try {
//			date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(_strDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}  
//		payment.setPay_date(date1);
//		System.out.println(payment.getPay_date()+":;;DATE");
		
		
		if(loanRepo.save(loan) != null) {
			return true;
		}else {
			return false;
		}
//		return true;
	}	

}
