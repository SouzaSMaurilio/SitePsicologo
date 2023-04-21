package com.souzasmaurilio.sitepsicologia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;

@Repository
public interface AdministradorRepositorio extends MongoRepository<Administrador, String> {
	
}
