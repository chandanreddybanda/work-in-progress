package com.learning.learningworks.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.learningworks.bean.Transaction;

@Repository
public interface ITransactionRepository extends MongoRepository<Transaction, String> {
	@Query(value = "", fields = "{'transactionDate':1,'transactionAmount':1,'transactionDescription':1}")
	public List<Transaction> findByCcNumber(String ccNumber, Sort sort); // scope for change
	
	@Query(value= "{'transactionDate':{ $gte : ?0 },'creditCardNumber':?1}",sort="{'transactionAmount': -1}")
	public List<Transaction> getMaxLastMonth(String date, String creditCardNumber);
}