package com.souzasmaurilio.sitepsicologia.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
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
}
