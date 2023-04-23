package com.souzasmaurilio.sitepsicologia.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.dto.UsuarioDTO;
import com.souzasmaurilio.sitepsicologia.repository.UsuarioRepositorio;
import com.souzasmaurilio.sitepsicologia.servico.exception.ObjetoNaoEncontradoException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repo;
	
	public List<Usuario> findAll(){
		 return repo.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	
	}
	
	public Usuario insert(Usuario obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Usuario update(Usuario obj) {
		Usuario novoObj = findById(obj.getId());
		updateData(novoObj, obj);
		return repo.save(novoObj);
	}
	
	private void updateData(Usuario novoObj, Usuario obj) {
		novoObj.setNome(obj.getNome());
		novoObj.setEmail(obj.getEmail());
	}

	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);	
	}
	
}
