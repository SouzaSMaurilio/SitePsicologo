package com.souzasmaurilio.sitepsychologist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.souzasmaurilio.sitepsychologist.dominio.Administrator;

@Repository
public interface AdministratorRepository extends MongoRepository<Administrator, String> {
	
}
