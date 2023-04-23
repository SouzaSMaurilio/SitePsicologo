package com.souzasmaurilio.sitepsicologia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.souzasmaurilio.sitepsicologia.dominio.Agenda;

@Repository
public interface AgendaRepositorio extends MongoRepository<Agenda, String> {
	
}
