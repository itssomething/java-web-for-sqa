package net.guides.springboot2.springboot2webappthymeleaf;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.Payment;
import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
import service.PaymentProcessService;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.LoanRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
@Transactional
public class FirstPaymentTests {
	@Autowired
	UserRepository userRepo;

	@Autowired
	LoanRepository loanRepo;

	User user = new User();
	Loan loan = new Loan();
	Payment payment = new Payment();
	PaymentProcessService payment_process_service = new PaymentProcessService();

	@Before
	public void setUp() {

		user.setEmail("vdmanh107@gmail.com");
		user.setRole(1);
		userRepo.save(user);
		int user_id = userRepo.findFirstByOrderByIdDesc().getId();
//		System.out.println(user_id + ";;UI");
		loan.setUser_id(user_id);
		loan.setType(1);
		loan.setCurrent_interest_rate((float) 0.07);
		loan.setAmount_of_money((double) 10000000);
		loan.setNumber_of_period(12);
		loan.setLending_time(12);
		loan.setRemaining_principal((double) 10000000);

		// date

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			Calendar cal = Calendar.getInstance();
			System.out.println(cal.getTime());
			date = format.parse(format.format(cal.getTime()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		loan.setTime_of_disbursement(date);
		System.out.println(loan.getTime_of_disbursement());
		loanRepo.save(loan);

		User user_tmp = userRepo.findFirstByOrderByIdDesc();
		payment.setUser_id(user_tmp.getId());
		Loan loan_tmp = loanRepo.findFirstByOrderByIdDesc();
		payment.setLoan_id(loan_tmp.getId());
		payment.setMoney_amount((double) 891667);
	}

	@Transactional
	@Test
	@Rollback(true)
	public void test() {
		System.out.println(payment.getMoney_amount() + "gl");
		payment_process_service = new PaymentProcessService(loanRepo, loan, payment);
		payment_process_service.processPayment(loan, payment);
		Loan new_loan = loanRepo.findFirstByOrderByIdDesc();
		Double new_loan_remaining_principal = new_loan.getRemaining_principal();
		assertEquals(Double.valueOf(Math.ceil(new_loan_remaining_principal)), Double.valueOf(9166667));
	}

}
