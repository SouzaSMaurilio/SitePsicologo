package com.souzasmaurilio.sitepsychologist.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.souzasmaurilio.sitepsychologist.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
		
		Optional<User> findByLogin(String login);

}
