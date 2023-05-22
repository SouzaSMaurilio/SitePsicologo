package com.souzasmaurilio.sitepsychologist.config;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

import com.souzasmaurilio.sitepsychologist.domain.Administrator;
import com.souzasmaurilio.sitepsychologist.domain.NewCalendar;
import com.souzasmaurilio.sitepsychologist.domain.Schedule;
import com.souzasmaurilio.sitepsychologist.domain.User;
import com.souzasmaurilio.sitepsychologist.dto.PatientScheduleDTO;
import com.souzasmaurilio.sitepsychologist.dto.UserDTO;
import com.souzasmaurilio.sitepsychologist.repository.AdministratorRepository;
import com.souzasmaurilio.sitepsychologist.repository.NewCalendarRepository;
import com.souzasmaurilio.sitepsychologist.repository.ScheduleRepository;
import com.souzasmaurilio.sitepsychologist.repository.UserRepository;
import com.souzasmaurilio.sitepsychologist.utils.CalendarUtils;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdministratorRepository admRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private NewCalendarRepository newCalendarRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		admRepository.deleteAll();
		scheduleRepository.deleteAll();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		sdfData.setTimeZone(TimeZone.getTimeZone("GMT"));
		sdfHora.setTimeZone(TimeZone.getTimeZone("GMT"));

		Schedule data1 = new Schedule(null, sdfData.parse("25/05/2023"), sdfHora.parse("14:30"));
		Schedule data2 = new Schedule(null, sdfData.parse("25/05/2023"), sdfHora.parse("16:00"));
		Schedule data3 = new Schedule(null, sdfData.parse("25/05/2023"), sdfHora.parse("11:00"));

		scheduleRepository.saveAll(Arrays.asList(data1, data2, data3));

		User bob = new User(null, "Bob Grey", "bob@gmail.com", "Seth", "Toguro", new PatientScheduleDTO(data2));
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "MaBr", "Motoneta", new PatientScheduleDTO(data1));
		User alex = new User(null, "Alex Green", "alex@gmail.com", "BoboVence", "Sariba", new PatientScheduleDTO(data3));

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		UserDTO patient1 = new UserDTO(maria);
		UserDTO patient2 = new UserDTO(bob);
		UserDTO patient3 = new UserDTO(alex);
		
		Administrator bruno = new Administrator(null, "Bruno Bina", "Bruno@outlook.com", "Bina", "@1234568", null);
		bruno.setPatients(Arrays.asList(patient1, patient2, patient3));
		
		admRepository.saveAll(Arrays.asList(bruno));
		
		System.out.println(newCalendarRepository.findByDate(LocalDate.parse("2023/05/15", formatter), PageRequest.of(0, 1)).getContent().get(0));
	
		CalendarUtils.generateNext90days();
	}
}