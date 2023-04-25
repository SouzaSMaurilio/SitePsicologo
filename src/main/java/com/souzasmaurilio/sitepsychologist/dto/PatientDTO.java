package com.souzasmaurilio.sitepsychologist.dto;

import java.io.Serializable;

import com.souzasmaurilio.sitepsychologist.domain.User;


public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private PatientScheduleDTO patientSchedule;
	
	public PatientDTO() {
	}

	public PatientDTO(User Patient, PatientScheduleDTO patientSchedule) {
		id = Patient.getId();
		name = Patient.getName();
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

	public PatientScheduleDTO getPatientSchedule() {
		return patientSchedule;
	}

	public void setPatientSchedule(PatientScheduleDTO patientSchedule) {
		this.patientSchedule = patientSchedule;
	}
	
	

}
