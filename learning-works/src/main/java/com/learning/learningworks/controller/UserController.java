package com.learning.learningworks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.learningworks.bean.CreditCard;
import com.learning.learningworks.bean.CustomPOJO_A;
import com.learning.learningworks.bean.CustomPOJO_B;
import com.learning.learningworks.bean.Transaction;
import com.learning.learningworks.bean.User;
import com.learning.learningworks.service.UserDBService;

@RestController
public class UserController {

	private String userEmail = "c1@gmail.com";

	@Autowired
	private UserDBService service;

	@GetMapping(path = "/api/users")
	public List<User> getAllUsersFromDB() {
		return service.getAllUserFromUserDB();
	}
	
	@GetMapping(path = "/api/transactions")
	public List<Transaction> getAllTransactionsFromDB() {
		return service.getAllTransactions();
	}

	@GetMapping(path = "/api/creditcard") /// api/customer/creditcards/expenses
	public CreditCard getAllCreditCards(@PathParam(value = "") String ccnum) {
		return service.getCreditCardById(ccnum);
	}

	@GetMapping(path = "/api/transaction") /// api/customer/creditcards/expenses
	public List<CustomPOJO_B> getTransaction(@PathParam(value = "") String tranNumber) {
		return service.getTransactionByCcNumber(tranNumber,2);
	}

	@GetMapping(path = "/api/customer/creditcards/expenses") /// api/customer/creditcards/expenses
	public List<CustomPOJO_A> getLastXnumberOfExpences(@PathParam(value = "") String transactions) {

		List<String> creditCardNumbers = this.service.getAllCreditCardsForUser(this.userEmail);
		List<CustomPOJO_A> Lcp = new ArrayList<CustomPOJO_A>();
		for (String ccNumber : creditCardNumbers) {
			List<CustomPOJO_B> lt = service.getTransactionByCcNumber(ccNumber, Integer.parseInt(transactions));
			Lcp.add(new CustomPOJO_A(ccNumber,lt));
		}
		return Lcp;
	}
}
