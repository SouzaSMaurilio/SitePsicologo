package com.souzasmaurilio.sitepsychologist.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.souzasmaurilio.sitepsychologist.dto.PatientDTO;

@Document(collection = "schedule")
public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date date;
	private Date time;
	private PatientDTO patient;
	
	public Schedule() {
	}

	public Schedule(String id, Date date, Date time, PatientDTO patient) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.patient = patient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}


	public PatientDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}
	
	public void setHorario(Date time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, time, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(date, other.date) && Objects.equals(time, other.time)
				&& Objects.equals(id, other.id);
	}

	
}
