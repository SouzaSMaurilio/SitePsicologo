package com.souzasmaurilio.sitepsicologia.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.servico.UsuarioServico;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioRecurso {

	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
 	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
}
