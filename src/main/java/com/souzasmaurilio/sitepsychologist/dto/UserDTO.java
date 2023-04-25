package com.souzasmaurilio.sitepsychologist.dto;

import java.io.Serializable;

import com.souzasmaurilio.sitepsychologist.domain.User;


public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private PatientScheduleDTO patienteSchedule;

	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
		patienteSchedule = obj.getPatientSchedule();
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

	public PatientScheduleDTO getPatienteSchedule() {
		return patienteSchedule;
	}

	public void setPatienteSchedule(PatientScheduleDTO patienteSchedule) {
		this.patienteSchedule = patienteSchedule;
	}	

}
