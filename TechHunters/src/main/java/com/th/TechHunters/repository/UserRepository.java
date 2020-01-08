package com.th.TechHunters.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.th.TechHunters.model.User;

public interface UserRepository extends MongoRepository<User, Long> {
	public User findByEmailAndPwd(String email, String pwd);
}
