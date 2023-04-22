package com.souzasmaurilio.sitepsicologia.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dto.AdministradorDTO;
import com.souzasmaurilio.sitepsicologia.repository.AdministradorRepositorio;
import com.souzasmaurilio.sitepsicologia.servico.exception.ObjetoNaoEncontradoException;

@Service
public class AdministradorServico {

	@Autowired
	private AdministradorRepositorio repo;
	
	public List<Administrador> findAll(){
		 return repo.findAll();
	}
	
	public Administrador findById(String id) {
		Optional<Administrador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	
	}
	
	public Administrador insert(Administrador obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Administrador update(Administrador obj) {
		Administrador novoObj = findById(obj.getId());
		updateDate(novoObj, obj);
		return repo.save(novoObj);
	}
	
	private void updateDate(Administrador novoObj, Administrador obj) {
		novoObj.setNome(obj.getNome());
		novoObj.setEmail(obj.getEmail());
	}
	
	public Administrador fromDTO(AdministradorDTO objDTO) {
		return new Administrador(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);	
	}
}
