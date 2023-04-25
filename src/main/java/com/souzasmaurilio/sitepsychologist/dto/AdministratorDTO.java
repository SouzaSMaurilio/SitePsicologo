package com.souzasmaurilio.sitepsychologist.dto;

import java.io.Serializable;
import java.util.List;

import com.souzasmaurilio.sitepsychologist.domain.Administrator;

public class AdministratorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private List<UserDTO> patients;
	
	public AdministratorDTO() {
		
	}
	
	public AdministratorDTO(Administrator obj) {
		id = obj.getId();
		name = obj.getAdmName();
		email = obj.getEmail();
		patients = obj.getPatients();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserDTO> getPatients() {
		return patients;
	}

	public void setPatients(List<UserDTO> patients) {
		this.patients = patients;
	}
	
}
