package com.souzasmaurilio.sitepsychologist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsychologist.dominio.User;
import com.souzasmaurilio.sitepsychologist.dto.UserDTO;
import com.souzasmaurilio.sitepsychologist.repository.UserRepository;
import com.souzasmaurilio.sitepsychologist.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		 return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User novoObj = findById(obj.getId());
		updateData(novoObj, obj);
		return repo.save(novoObj);
	}
	
	private void updateData(User novoObj, User obj) {
		novoObj.setName(obj.getName());
		novoObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), null, null, null);
	}
	
}
