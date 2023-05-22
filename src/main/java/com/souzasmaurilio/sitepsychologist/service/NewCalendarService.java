package com.souzasmaurilio.sitepsychologist.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsychologist.domain.NewCalendar;
import com.souzasmaurilio.sitepsychologist.repository.NewCalendarRepository;

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
	
	public void delete(String id) throws ParseException {
//		findById(id);
//		repo.deleteById(sdfData.parse(id));
	}
	
	public NewCalendar update(NewCalendar obj) {
		return repo.save(obj);
	}
	
//	private void updateData(NewCalendar novoObj, NewCalendar obj) {
//		novoObj.setAdmName(obj.getAdmName());
//		novoObj.setEmail(obj.getEmail());
//	}
	
//	public NewCalendar fromDTO(NewCalendarDTO objDTO) {
//		return new NewCalendar(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null, null);	
//	}
}
