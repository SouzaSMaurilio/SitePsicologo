package com.souzasmaurilio.sitepsychologist.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "calendar")
public class NewCalendar implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private LocalDate date;
	private Map<String, Boolean> officeHours;

	public NewCalendar() {
	}

	public NewCalendar(String id, LocalDate date) {
		this.id = id;
		this.date = date;
		this.officeHours = new HashMap<String, Boolean>();
		officeHours.put("08:00", true);
		officeHours.put("09:00", true);
		officeHours.put("10:00", true);
		officeHours.put("11:00", true);
		officeHours.put("12:00", false);
		officeHours.put("13:00", true);
		officeHours.put("14:00", true);
		officeHours.put("15:00", true);
		officeHours.put("16:00", true);
		officeHours.put("17:00", true);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Map<String, Boolean> getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(Map<String, Boolean> officeHours) {
		this.officeHours = officeHours;
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
		NewCalendar other = (NewCalendar) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NewCalendar [id=" + id + ", date=" + date + ", officeHours=" + officeHours + "]";
	}
}
