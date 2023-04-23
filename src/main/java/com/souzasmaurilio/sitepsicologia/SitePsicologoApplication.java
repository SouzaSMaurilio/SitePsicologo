package com.souzasmaurilio.sitepsicologia;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.servico.UsuarioServico;

@SpringBootApplication
public class SitePsicologoApplication {
	
		   @Autowired
		    private UsuarioServico usuarioServico;

		    public static void main(String[] args) {
		        SpringApplication.run(SitePsicologoApplication.class, args);
		    }

		    @Bean
		    public CommandLineRunner run() {
		        return args -> {
		            Scanner scanner = new Scanner(System.in);
		            
		            System.out.println("Digite o ID do usuário:");
		            String id = scanner.nextLine();
		            
		            System.out.println("Digite o nome do usuário:");
		            String nome = scanner.nextLine();
		            
		            System.out.println("Digite o email do usuário:");
		            String email = scanner.nextLine();
		            
		            System.out.println("Digite o login do usuário:");
		            String login = scanner.nextLine();
		            
		            System.out.println("Digite a senha do usuário:");
		            String senha = scanner.nextLine();
		            
		            Usuario usuario = new Usuario(id, nome, email, login, senha);
		            usuarioServico.insert(usuario);
		            
		            scanner.close();
		        };
		    }

		}
