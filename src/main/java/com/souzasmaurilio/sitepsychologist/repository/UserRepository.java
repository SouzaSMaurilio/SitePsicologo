package com.souzasmaurilio.sitepsychologist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.souzasmaurilio.sitepsychologist.dominio.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
