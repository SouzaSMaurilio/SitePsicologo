package com.souzasmaurilio.sitepsychologist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.souzasmaurilio.sitepsychologist.domain.NewCalendar;
import com.souzasmaurilio.sitepsychologist.repository.AdministratorRepository;
import com.souzasmaurilio.sitepsychologist.repository.ScheduleRepository;
import com.souzasmaurilio.sitepsychologist.repository.UserRepository;
import com.souzasmaurilio.sitepsychologist.service.UserService;

@SpringBootApplication
@EnableMongoRepositories
public class SitePsychologistApplication {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AdministratorRepository admRepository;

    public static void main(String[] args) {
        SpringApplication.run(SitePsychologistApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run() {
//        return args -> {
//
//        	
//            List<User> patients = userService.findAll();
//            Calendar calendar = new Calendar();
//            
//            
//            
//            Scanner scanner = new Scanner(System.in);
//
//            SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
//            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
//            sdfDate.setTimeZone(TimeZone.getTimeZone("GMT"));
//            sdfTime.setTimeZone(TimeZone.getTimeZone("GMT"));
//
//            System.out.println("Digite o nome do usuário:");
//            String name = scanner.nextLine();
//
//            System.out.println("Digite o email do usuário:");
//            String email = scanner.nextLine();
//
//            System.out.println("Digite o login do usuário:");
//            String login = scanner.nextLine();
//
//            System.out.println("Digite a senha do usuário:");
//            String password = scanner.nextLine();
//
//            User user = new User(null, name, email, login, password, null);
//            userService.insert(user);
//            
//            System.out.println("Digite a data da consulta: (dd/mm/aaaa)");
//            String date = scanner.nextLine();
//
//            System.out.println("Digite o horario da consulta: (HH:mm)");
//            String time = scanner.nextLine();
//            
//            Schedule schedule = new Schedule(null, sdfDate.parse(date), sdfTime.parse(time));
//            scheduleRepository.save(schedule);
//            
//            if (calendar.isDateValid(date) == true) {
//            	System.out.println("Data valida");
//            }
//            else {
//            	System.out.println("Data invalida: Por favor escolha uma nova data");
//            }
//          
//            if (calendar.isTimeValid(time) == true) {
//            	System.out.println("Horario valido");
//            }
//            else {
//            	System.out.println("Horario invalido: Por favor escolha outro horario");
//            }
//            
//            user.setPatientSchedule(new PatientScheduleDTO(schedule));
//
//            List<Administrator> adms = admRepository.findAll();
//            for (Administrator adm : adms) {
//                UserDTO userDTO = new UserDTO(user);
//                adm.getPatients().add(userDTO);
//                admRepository.save(adm);
//            }
//            
//            
//            System.out.println("Digite o usuário ou email");
//            String loginReal = scanner.nextLine();
//                        
//            System.out.println("Digite a sua senha");
//            String senhaReal = scanner.nextLine();
//                        
//            Optional<User> verification = userRepository.findByLogin(loginReal);
//                        
//            if (verification.isPresent()) {
//                User obj = verification.get();
//                if (obj.getPassword().equals(senhaReal)) {
//                    System.out.println("Login bem-sucedido");
//                } else {
//                    System.out.println("Senha incorreta");
//                }
//            } else {
//                System.out.println("Email inválido");
//            }
// 
//    //corrigir para um if simples:
//    
//	for(NewCalendar a: list) {
//		System.out.println(a.getOfficeHours().get("10:00"));
//		if(a.getOfficeHours().containsKey("10:00")) {
//			a.getOfficeHours().put("10:00", false);
//		}
//		System.out.println(a.getOfficeHours().get("10:00"));
//		
//		newCalendarRepository.save(a);
//	}
//	
//	
//
//          
//
//            scanner.close();
//        };
//    }

}
