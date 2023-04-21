package com.souzasmaurilio.sitepsicologia.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.repository.AdministradorRepositorio;
import com.souzasmaurilio.sitepsicologia.repository.UsuarioRepositorio;

@Configuration
public class intanciacao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private AdministradorRepositorio admRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepositorio.deleteAll();
		

		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
	
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
		
		admRepositorio.deleteAll();

		Administrador bruno = new Administrador(null, "Bruno Bina", "Bruno@outlook.com", "Bina", "@1234568");
		Administrador larissa = new Administrador(null, "Larissa Pissul", "LarySuul@outlook.com", "LariSul", "@235844668");

	
		admRepositorio.saveAll(Arrays.asList(bruno, larissa));
	}
	
}
