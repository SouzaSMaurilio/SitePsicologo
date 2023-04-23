package com.souzasmaurilio.sitepsicologia.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.souzasmaurilio.sitepsicologia.dto.pacienteDTO;

@Document(collection = "agenda")
public class Agenda implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date data;
	private Date horario;
	private pacienteDTO paciente;
	
	public Agenda() {
	}

	public Agenda(String id, Date data, Date horario, pacienteDTO paciente) {
		super();
		this.id = id;
		this.data = data;
		this.horario = horario;
		this.paciente = paciente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorario() {
		return horario;
	}


	public pacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(pacienteDTO paciente) {
		this.paciente = paciente;
	}
	
	public void setHorario(Date horario) {
		horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, horario, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(data, other.data) && Objects.equals(horario, other.horario)
				&& Objects.equals(id, other.id);
	}

	
}
