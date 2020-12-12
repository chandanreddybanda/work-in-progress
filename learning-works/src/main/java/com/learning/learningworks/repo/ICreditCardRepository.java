package com.learning.learningworks.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.learning.learningworks.bean.CreditCard;

@Repository
public interface ICreditCardRepository extends MongoRepository<CreditCard, String> {

}
