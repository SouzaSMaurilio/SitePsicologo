package com.souzasmaurilio.sitepsychologist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.souzasmaurilio.sitepsychologist.repository.ScheduleRepository;
import com.souzasmaurilio.sitepsychologist.service.UserService;

@SpringBootApplication
public class SitePsychologistApplication {
	
		   @Autowired
		    private UserService UserService;

		   @Autowired
		    private ScheduleRepository ar;
		   
		    public static void main(String[] args) {
		        SpringApplication.run(SitePsychologistApplication.class, args);
		    }

//		    @Bean
//		    public CommandLineRunner run() {
//		        return args -> {
//		            Scanner scanner = new Scanner(System.in);
//		            
//		            SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
//		    		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
//		            sdfDate.setTimeZone(TimeZone.getTimeZone("GMT"));
//		    		sdfTime.setTimeZone(TimeZone.getTimeZone("GMT"));
//		            
//		            System.out.println("Digite o nome do usuário:");
//		            String name = scanner.nextLine();
//		            
//		            System.out.println("Digite o email do usuário:");
//		            String email = scanner.nextLine();
//		            
//		            System.out.println("Digite o login do usuário:");
//		            String login = scanner.nextLine();
//		            
//		            System.out.println("Digite a senha do usuário:");
//		            String password = scanner.nextLine();
//		            
//		            User user = new User(null, name, email, login, password);
//		            UserService.insert(user);
//		            
//		            System.out.println("Digite a data da consulta: (dd/mm/aaaa)");
//		            String date = scanner.nextLine();
//		            
//		            System.out.println("Digite o horario da consulta: (HH:mm)");
//		            String time = scanner.nextLine();
//		            
//		            Schedule schedule = new Schedule(null , sdfDate.parse(date), sdfTime.parse(time), new PatientDTO(user));
//		            ar.save(schedule);
//		            scanner.close();
//		        };
//		    }

		}
