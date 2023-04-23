package com.souzasmaurilio.sitepsicologia.dto;

import java.io.Serializable;

import com.souzasmaurilio.sitepsicologia.dominio.Usuario;


public class pacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	
	public pacienteDTO() {
	}

	public pacienteDTO(Usuario paciente) {
		id = paciente.getId();
		nome = paciente.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
