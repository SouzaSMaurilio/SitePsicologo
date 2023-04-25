package com.souzasmaurilio.sitepsychologist.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.souzasmaurilio.sitepsychologist.dto.UserDTO;

@Document(collection = "adm")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String admName;
	private String email;
	private String login;
	private String password;
	private List<UserDTO> patients;
	
	public Administrator() {
		
	}

	public Administrator(String id, String admName, String email, String login, String password, List<UserDTO> patients) {
		this.id = id;
		this.admName = admName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.patients = patients;
	}


	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String nome) {
		this.admName = nome;
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

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public List<UserDTO> getPatients() {
		return patients;
	}

	public void setPatients(List<UserDTO> patients) {
		this.patients = patients;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		return Objects.equals(id, other.id);
	}
	
}
