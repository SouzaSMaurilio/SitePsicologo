package com.souzasmaurilio.sitepsychologist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.souzasmaurilio.sitepsychologist.dominio.Schedule;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, String> {
	
}
