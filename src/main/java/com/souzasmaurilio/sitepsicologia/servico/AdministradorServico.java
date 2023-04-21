package com.souzasmaurilio.sitepsicologia.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.repository.AdministradorRepositorio;

@Service
public class AdministradorServico {

	@Autowired
	private AdministradorRepositorio repo;
	
	public List<Administrador> findAll(){
		 return repo.findAll();
	}
	
}
