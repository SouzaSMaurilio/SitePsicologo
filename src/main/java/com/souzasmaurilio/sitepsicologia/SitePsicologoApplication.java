package com.souzasmaurilio.sitepsicologia;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.souzasmaurilio.sitepsicologia.dominio.Agenda;
import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.dto.pacienteDTO;
import com.souzasmaurilio.sitepsicologia.repository.AgendaRepositorio;
import com.souzasmaurilio.sitepsicologia.servico.UsuarioServico;

@SpringBootApplication
public class SitePsicologoApplication {
	
		   @Autowired
		    private UsuarioServico usuarioServico;

		   @Autowired
		    private AgendaRepositorio ar;
		   
		    public static void main(String[] args) {
		        SpringApplication.run(SitePsicologoApplication.class, args);
		    }

		    @Bean
		    public CommandLineRunner run() {
		        return args -> {
		            Scanner scanner = new Scanner(System.in);
		            
		            SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
		    		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		            sdfData.setTimeZone(TimeZone.getTimeZone("GMT"));
		    		sdfHora.setTimeZone(TimeZone.getTimeZone("GMT"));
		            
		            System.out.println("Digite o nome do usuário:");
		            String nome = scanner.nextLine();
		            
		            System.out.println("Digite o email do usuário:");
		            String email = scanner.nextLine();
		            
		            System.out.println("Digite o login do usuário:");
		            String login = scanner.nextLine();
		            
		            System.out.println("Digite a senha do usuário:");
		            String senha = scanner.nextLine();
		            
		            Usuario usuario = new Usuario(null, nome, email, login, senha);
		            usuarioServico.insert(usuario);
		            
		            System.out.println("Digite a data da consulta: (dd/mm/aaaa)");
		            String data = scanner.nextLine();
		            
		            System.out.println("Digite o horario da consulta: (HH:mm)");
		            String horario = scanner.nextLine();
		            
		            Agenda agenda = new Agenda(null , sdfData.parse(data), sdfHora.parse(horario), new pacienteDTO(usuario));
		            ar.save(agenda);
		            scanner.close();
		        };
		    }

		}
