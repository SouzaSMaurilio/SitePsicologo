package com.souzasmaurilio.sitepsychologist.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.souzasmaurilio.sitepsychologist.domain.Schedule;

public class PatientScheduleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date date;
	@JsonFormat(pattern="HH:mm")
	private Date time;
	
	public PatientScheduleDTO() {
	}

	public PatientScheduleDTO(Schedule schedule) {
		this.date = schedule.getDate();
		this.time = schedule.getTime();
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

	public void setTime(Date time) {
		this.time = time;
	}
}
