package service;

import java.util.Optional;

import net.guides.springboot2.springboot2webappthymeleaf.domain.Loan;
import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.LoanRepository;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;

public class LoanService {
	Loan loan;
	User user;
	UserRepository userRepo;
	
	public LoanService() {
		
	}
	
	public LoanService(Loan loan, User user, UserRepository userRepo) {
		super();
		this.loan = loan;
		this.user = user;
		this.userRepo = userRepo;
	}

	public boolean loanCreatable() {
		
		Optional<User> temp_user = userRepo.findById(user.getId());
		System.out.println(temp_user.get().getIncome());
		User user_temp = temp_user.get();
		Double income = user_temp.getIncome();
		Double money_amount = loan.getAmount_of_money();
		if(income <= Math.pow(10,7) && money_amount <= Math.pow(10,7) * 30 && money_amount < income * 10) { //10 trieu, 300 trieu
			return true;
		}
		else if(income > Math.pow(10,7) && money_amount <= Math.pow(10,7) * 30 && money_amount < income * 10) { //10 trieu, 300 trieu
			return true;
		}
		else if(money_amount > 300000000) { //10 trieu, 300 trieu
			return false;
		}
		else if(money_amount > income * 10) {
			return false;
		}
		else {
			return false;
		}
	}
}
