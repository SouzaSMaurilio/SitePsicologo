package com.souzasmaurilio.sitepsicologia.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.dto.UsuarioDTO;
import com.souzasmaurilio.sitepsicologia.servico.UsuarioServico;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
 	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> lista = servico.findAll();
		List<UsuarioDTO> listaDTO = lista.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
}
