package com.souzasmaurilio.sitepsychologist.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsychologist.domain.Administrator;
import com.souzasmaurilio.sitepsychologist.dto.AdministratorDTO;
import com.souzasmaurilio.sitepsychologist.repository.AdministratorRepository;
import com.souzasmaurilio.sitepsychologist.service.exception.ObjectNotFoundException;

@Service
public class AdministratorService {
	
	SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private AdministratorRepository repo;
	
	public List<Administrator> findAll(){
		 return repo.findAll();
	}
	
	public Administrator findById(String id) {
		Optional<Administrator> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	
	}
	
	public Administrator insert(Administrator obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Administrator update(Administrator obj) {
		Administrator novoObj = findById(obj.getId());
		updateData(novoObj, obj);
		return repo.save(novoObj);
	}
	
	private void updateData(Administrator novoObj, Administrator obj) {
		novoObj.setAdmName(obj.getAdmName());
		novoObj.setEmail(obj.getEmail());
	}
	
	public Administrator fromDTO(AdministratorDTO objDTO) {
		return new Administrator(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null, null);	
	}
}
