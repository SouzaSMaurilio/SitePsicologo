package com.souzasmaurilio.sitepsychologist.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.souzasmaurilio.sitepsychologist.dominio.Administrator;
import com.souzasmaurilio.sitepsychologist.dominio.Schedule;
import com.souzasmaurilio.sitepsychologist.dominio.User;
import com.souzasmaurilio.sitepsychologist.dto.PatientDTO;
import com.souzasmaurilio.sitepsychologist.dto.PatientScheduleDTO;
import com.souzasmaurilio.sitepsychologist.repository.AdministratorRepository;
import com.souzasmaurilio.sitepsychologist.repository.ScheduleRepository;
import com.souzasmaurilio.sitepsychologist.repository.UserRepository;

@Configuration
public class instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdministratorRepository admRepository;

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		admRepository.deleteAll();
		scheduleRepository.deleteAll();

		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		sdfData.setTimeZone(TimeZone.getTimeZone("GMT"));
		sdfHora.setTimeZone(TimeZone.getTimeZone("GMT"));

		Schedule data1 = new Schedule(null, sdfData.parse("25/05/2023"), sdfHora.parse("14:30"), null);
		Schedule data2 = new Schedule(null, sdfData.parse("25/05/2023"), sdfHora.parse("16:00"), null);
		Schedule data3 = new Schedule(null, sdfData.parse("25/05/2023"), sdfHora.parse("11:00"), null);

		scheduleRepository.saveAll(Arrays.asList(data1, data2, data3));

		User bob = new User(null, "Bob Grey", "bob@gmail.com", "Seth", "Toguro", new PatientScheduleDTO(data2));
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "MaBr", "Motoneta", new PatientScheduleDTO(data1));
		User alex = new User(null, "Alex Green", "alex@gmail.com", "BoboVence", "Sariba", new PatientScheduleDTO(data3));

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Administrator bruno = new Administrator(null, "Bruno Bina", "Bruno@outlook.com", "Bina", "@1234568");
		Administrator larissa = new Administrator(null, "Larissa Pissul", "LarySuul@outlook.com", "LariSul", "@235844668");

		admRepository.saveAll(Arrays.asList(bruno, larissa));

		data1.setPatient(new PatientDTO(maria));
		data2.setPatient(new PatientDTO(bob));
		data3.setPatient(new PatientDTO(alex));

		scheduleRepository.saveAll(Arrays.asList(data1, data2, data3));
	}

}
