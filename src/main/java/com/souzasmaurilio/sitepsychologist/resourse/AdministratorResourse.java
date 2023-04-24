package com.souzasmaurilio.sitepsychologist.resourse;

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

import com.souzasmaurilio.sitepsychologist.dominio.Administrator;
import com.souzasmaurilio.sitepsychologist.dto.AdministratorDTO;
import com.souzasmaurilio.sitepsychologist.service.AdministratorService;

@RestController
@RequestMapping(value="/adm")
public class AdministratorResourse {

	@Autowired
	private AdministratorService service;
	
	@GetMapping
 	public ResponseEntity<List<AdministratorDTO>> findAll() {
		List<Administrator> lista = service.findAll();
		List<AdministratorDTO> listaDTO = lista.stream().map(adm -> new AdministratorDTO(adm)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<AdministratorDTO> findById(@PathVariable String id) {
		Administrator obj = service.findById(id);
		return ResponseEntity.ok().body(new AdministratorDTO(obj));
	}
	
	@PostMapping
 	public ResponseEntity<Void> insert(@RequestBody AdministratorDTO objDTO) {
		Administrator obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
 	public ResponseEntity<Void> update(@RequestBody AdministratorDTO objDTO, @PathVariable String id) {
		Administrator obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
