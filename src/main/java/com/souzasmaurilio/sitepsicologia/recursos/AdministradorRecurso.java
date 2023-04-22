package com.souzasmaurilio.sitepsicologia.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.dto.AdministradorDTO;
import com.souzasmaurilio.sitepsicologia.dto.UsuarioDTO;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<AdministradorDTO> findById(@PathVariable String id) {
		Administrador obj = servico.findById(id);
		return ResponseEntity.ok().body(new AdministradorDTO(obj));
	}
	
	@PostMapping
 	public ResponseEntity<Void> insert(@RequestBody AdministradorDTO objDTO) {
		Administrador obj = servico.fromDTO(objDTO);
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
 	public ResponseEntity<Void> update(@RequestBody AdministradorDTO objDTO, @PathVariable String id) {
		Administrador obj = servico.fromDTO(objDTO);
		obj.setId(id);
		obj = servico.update(obj);
		return ResponseEntity.noContent().build();
	}
}
