package com.learning.learningworks.service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learning.learningworks.bean.CreditCard;
import com.learning.learningworks.bean.CustomPOJO_B;
import com.learning.learningworks.bean.Transaction;
import com.learning.learningworks.bean.User;
import com.learning.learningworks.repo.ICreditCardRepository;
import com.learning.learningworks.repo.ITransactionRepository;
import com.learning.learningworks.repo.IUserRepository;

@Service
public class UserDBService {

	@Autowired
	private IUserRepository repo;

	@Autowired
	private ICreditCardRepository crepo;

	@Autowired
	private ITransactionRepository trepo;

	public User getUserById(Integer userId) {
		Optional<User> optionalObj = this.repo.findById(userId);
		return optionalObj.get(); // scope for change
	}

	public User insertUserToUserDB(User user) {
		return this.repo.insert(user);
	}

	public User updateUserInUserDB(User user) {
		return this.repo.save(user);
	}

	public void deleteUserFromUserDB(Integer userId) {
		this.repo.deleteById(userId);
	}

	public List<User> getAllUserFromUserDB() {
		return this.repo.findAll();
	}

	public User getbyAddr(String Addr) {
		return this.repo.findByUserAddr(Addr);
	}

	public List<String> getAllCreditCardsFromUserDB(Integer userId) { // this will all credit cards for a customer
		return getUserById(userId).getUserCC();

	}
	
	public List<String> getAllCreditCardsForUser(String userEmail) { // this will all credit cards for a customer
		return getUserByEmailFromDB(userEmail).getUserCC();

	}
	
	public User getUserByEmailFromDB(String userEmail) {
		return this.repo.findByUserEmail(userEmail);
	}

	//
	// Credit Card
	//

	public CreditCard getCreditCardById(String ccNumber) {
		Optional<CreditCard> optionalObj = this.crepo.findById(ccNumber);
		return optionalObj.get(); // scope for change
	}

	public CreditCard insertToCCDB(CreditCard cc) {
		return this.crepo.insert(cc);
	}

	public CreditCard UpdateCreditCardInCCDB(CreditCard cc) {
		return this.crepo.save(cc);
	}

	public List<CreditCard> getAllCreditCardsFromCCDB() {
		return this.crepo.findAll();
	}

	//
	// Transaction
	//
	
	public List<Transaction> getAllTransactions(){
		return this.trepo.findAll();
	}

	public Transaction getTransactionById(String transactionNumber) {
		Optional<Transaction> optionalObj = this.trepo.findById(transactionNumber);
		return optionalObj.get(); // scope for change
	}

	public List<CustomPOJO_B> getTransactionByCcNumber(String ccNumber, int number) {
		Sort sort = Sort.by(Sort.Direction.DESC, "transactionAmount");
		List<Transaction> tr = this.trepo.findByCcNumber(ccNumber, sort);
		List<Transaction> ret = new ArrayList<Transaction>();
		for (Transaction temp : tr) {
			if (temp.getTransactionDate().getMonth().compareTo(LocalDate.now().getMonth()) < 0) {
				ret.add(temp);
			}
		}
		List<CustomPOJO_B> cp1 = new ArrayList<CustomPOJO_B>();
		ret = ret.subList(0, Math.min(ret.size(), number));
		for (Transaction t1 : ret) {
			CustomPOJO_B c1 = new CustomPOJO_B(
					t1.getTransactionDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.US),
					t1.getTransactionAmount(), t1.getTransactionDescription());
			cp1.add(c1);
		}
		return cp1;
	}

}
