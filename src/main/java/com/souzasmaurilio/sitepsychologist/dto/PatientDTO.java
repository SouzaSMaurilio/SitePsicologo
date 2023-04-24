package com.souzasmaurilio.sitepsychologist.dto;

import java.io.Serializable;

import com.souzasmaurilio.sitepsychologist.dominio.User;


public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	public PatientDTO() {
	}

	public PatientDTO(User Patient) {
		id = Patient.getId();
		name = Patient.getName();
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

}
