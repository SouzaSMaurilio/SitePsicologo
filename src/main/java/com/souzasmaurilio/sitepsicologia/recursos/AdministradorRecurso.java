package com.souzasmaurilio.sitepsicologia.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dto.AdministradorDTO;
import com.souzasmaurilio.sitepsicologia.servico.AdministradorServico;

@RestController
@RequestMapping(value="/adm")
public class AdministradorRecurso {

	@Autowired
	private AdministradorServico servico;
	
	@GetMapping
 	public ResponseEntity<List<AdministradorDTO>> findAll() {
		List<Administrador> lista = servico.findAll();
		List<AdministradorDTO> listaDTO = lista.stream().map(adm -> new AdministradorDTO(adm)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
}
