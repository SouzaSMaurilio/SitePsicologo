package com.souzasmaurilio.sitepsicologia.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
		Usuario obj = servico.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(obj));
	}
	
	@PostMapping
 	public ResponseEntity<Void> insert(@RequestBody UsuarioDTO objDTO) {
		Usuario obj = servico.fromDTO(objDTO);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
