package net.guides.springboot2.springboot2webappthymeleaf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.LoanRepository;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;
import service.LoanService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
@Transactional
public class LendingFailOne {
	// vay qua 10 lan thu nhap
	@Autowired
	UserRepository userRepo;

	@Autowired
	LoanRepository loanRepo;
	
	User user = new User();
	Loan loan = new Loan();
	LoanService loan_service = new LoanService();
	
	@Before
	public void setUp() {
		user.setEmail("vdmanh107@gmail.com");
		user.setRole(1);
		user.setIncome((double) 1); 
		userRepo.save(user);
		System.out.println(user.getIncome()+ "lso");
		
		int user_id = userRepo.findFirstByOrderByIdDesc().getId();
		loan.setUser_id(user_id);
		loan.setType(1);
		loan.setCurrent_interest_rate((float) 0.07);
		loan.setAmount_of_money((double) 11); 
		loan.setNumber_of_period(12);
		loan.setLending_time(12);
		loan.setRemaining_principal((double) 11); 

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
	}
	
	@Transactional
	@Test
	@Rollback(true)
	public void test() {
		loan_service = new LoanService(loan, user, userRepo);
		loan.setUser(user);
		assertFalse(loan_service.loanCreatable());
	}
}
