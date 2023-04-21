package com.souzasmaurilio.sitepsicologia.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
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
}
