package com.souzasmaurilio.sitepsychologist.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.souzasmaurilio.sitepsychologist.domain.NewCalendar;

@Repository
public interface NewCalendarRepository extends MongoRepository<NewCalendar, String> {

	@Query("{'date': ?0}")
	Page<NewCalendar> findByDate(LocalDate date, Pageable pages);
	
	@Query("{'_id': ?0}")
	public NewCalendar update(String calendarId, String Hour);
}
