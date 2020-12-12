package com.learning.learningworks.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.learningworks.bean.User;

@Repository
public interface IUserRepository extends MongoRepository<User,Integer>{
	
	@Query(value = "{ 'userGender':'Male' }")
	public User findByUserAddr(String userAddr);						//scope for change
	
	@Query(value="")
	public User findByUserEmail(String userEmail);

}
