package com.souzasmaurilio.sitepsychologist.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.souzasmaurilio.sitepsychologist.dto.PatientDTO;

@Document(collection = "schedule")
public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date date;
	@JsonFormat(pattern="HH:mm")
	private Date time;
	
	public Schedule() {
	}

	public Schedule(String id, Date date, Date time) {
		this.id = id;
		this.date = date;
		this.time = time;
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
