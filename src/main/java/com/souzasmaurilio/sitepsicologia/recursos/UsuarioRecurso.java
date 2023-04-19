package com.souzasmaurilio.sitepsicologia.recursos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souzasmaurilio.sitepsicologia.dominio.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioRecurso {

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		
		Usuario Maria = new Usuario(null, "Maria Silva", "maria@gmail.com");
		Usuario Alex = new Usuario(null, "Alex Francisco", "Af@gmail.com");
		Usuario Roberto = new Usuario(null, "Roberto Alberto", "RobAlb@outlook.com");
		
		List<Usuario> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(Maria, Alex, Roberto));
		return ResponseEntity.ok().body(lista);
	}
}
