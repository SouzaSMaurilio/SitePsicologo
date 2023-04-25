package com.souzasmaurilio.sitepsychologist.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.souzasmaurilio.sitepsychologist.dto.PatientScheduleDTO;

@Document(collection = "patient")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	private String login;
	private String password;
	private PatientScheduleDTO patientSchedule;
	
	public User() {
		
	}

	public User(String id, String name, String email, String login, String password, PatientScheduleDTO patientSchedule) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.login = login;
		this.password = password;
		this.patientSchedule = patientSchedule;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassord(String password) {
		this.password = password;
	}
	
	public PatientScheduleDTO getPatientSchedule() {
		return patientSchedule;
	}

	public void setPatientSchedule(PatientScheduleDTO patientSchedule) {
		this.patientSchedule = patientSchedule;
	}

	@Override
	public int hashCode() {
		final int first = 31;
		int result = 1;
		result = first * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
