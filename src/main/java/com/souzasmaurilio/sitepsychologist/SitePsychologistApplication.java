package com.souzasmaurilio.sitepsychologist;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.souzasmaurilio.sitepsychologist.domain.Administrator;
import com.souzasmaurilio.sitepsychologist.domain.Schedule;
import com.souzasmaurilio.sitepsychologist.domain.User;
import com.souzasmaurilio.sitepsychologist.dto.PatientScheduleDTO;
import com.souzasmaurilio.sitepsychologist.dto.UserDTO;
import com.souzasmaurilio.sitepsychologist.repository.AdministratorRepository;
import com.souzasmaurilio.sitepsychologist.repository.ScheduleRepository;
import com.souzasmaurilio.sitepsychologist.service.UserService;

@SpringBootApplication
public class SitePsychologistApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AdministratorRepository admRepository;

    public static void main(String[] args) {
        SpringApplication.run(SitePsychologistApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {

            List<User> patients = userService.findAll();

            Scanner scanner = new Scanner(System.in);

            SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
            sdfDate.setTimeZone(TimeZone.getTimeZone("GMT"));
            sdfTime.setTimeZone(TimeZone.getTimeZone("GMT"));

            System.out.println("Digite o nome do usuário:");
            String name = scanner.nextLine();

            System.out.println("Digite o email do usuário:");
            String email = scanner.nextLine();

            System.out.println("Digite o login do usuário:");
            String login = scanner.nextLine();

            System.out.println("Digite a senha do usuário:");
            String password = scanner.nextLine();

            User user = new User(null, name, email, login, password, null);
            userService.insert(user);

            System.out.println("Digite a data da consulta: (dd/mm/aaaa)");
            String date = scanner.nextLine();

            System.out.println("Digite o horario da consulta: (HH:mm)");
            String time = scanner.nextLine();

            Schedule schedule = new Schedule(null, sdfDate.parse(date), sdfTime.parse(time));
            scheduleRepository.save(schedule);

            user.setPatientSchedule(new PatientScheduleDTO(schedule));

            List<Administrator> adms = admRepository.findAll();
            for (Administrator adm : adms) {
                UserDTO userDTO = new UserDTO(user);
                adm.getPatients().add(userDTO);
                admRepository.save(adm);
            }

            scanner.close();
        };
    }

}
