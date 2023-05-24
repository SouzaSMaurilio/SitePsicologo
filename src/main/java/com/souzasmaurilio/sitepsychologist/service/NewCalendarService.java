package com.souzasmaurilio.sitepsychologist.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsychologist.domain.NewCalendar;
import com.souzasmaurilio.sitepsychologist.domain.User;
import com.souzasmaurilio.sitepsychologist.repository.NewCalendarRepository;
import com.souzasmaurilio.sitepsychologist.service.exception.ObjectNotFoundException;

@Service
public class NewCalendarService {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	private NewCalendarRepository repo;
	
	public List<NewCalendar> findAll(){
		 return repo.findAll();
	}
	
	public Optional<NewCalendar> findByDate(String date) throws ParseException {
		Pageable pages = PageRequest.of(0, 1);
		Page<NewCalendar> obj = repo.findByDate(LocalDate.parse(date, formatter), pages);
		return Optional.of(obj.getContent().get(0));
	}
	
	public NewCalendar insert(NewCalendar obj) {
		return repo.insert(obj);        
    }
	
	public Optional<NewCalendar> findById(String id){
		Optional<NewCalendar> obj = repo.findById(id);
		return obj;
	}
	
}
