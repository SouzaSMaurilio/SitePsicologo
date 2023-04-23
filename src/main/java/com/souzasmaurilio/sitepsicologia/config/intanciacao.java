package com.souzasmaurilio.sitepsicologia.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.souzasmaurilio.sitepsicologia.dominio.Administrador;
import com.souzasmaurilio.sitepsicologia.dominio.Agenda;
import com.souzasmaurilio.sitepsicologia.dominio.Usuario;
import com.souzasmaurilio.sitepsicologia.dto.pacienteDTO;
import com.souzasmaurilio.sitepsicologia.repository.AdministradorRepositorio;
import com.souzasmaurilio.sitepsicologia.repository.AgendaRepositorio;
import com.souzasmaurilio.sitepsicologia.repository.UsuarioRepositorio;

@Configuration
public class intanciacao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private AdministradorRepositorio admRepositorio;
	
	@Autowired
	private AgendaRepositorio agendaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepositorio.deleteAll();
		admRepositorio.deleteAll();
		agendaRepositorio.deleteAll();
		
		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
		sdfData.setTimeZone(TimeZone.getTimeZone("GMT"));
		sdfHora.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com", null, null);
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com", null, null);
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com", null, null);
	
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));
		
		Administrador bruno = new Administrador(null, "Bruno Bina", "Bruno@outlook.com", "Bina", "@1234568");
		Administrador larissa = new Administrador(null, "Larissa Pissul", "LarySuul@outlook.com", "LariSul", "@235844668");

		admRepositorio.saveAll(Arrays.asList(bruno, larissa));
		
		Agenda data1 = new Agenda(null, sdfData.parse("25/05/2023"), sdfHora.parse("14:30"), new pacienteDTO(maria));
		Agenda data2 = new Agenda(null, sdfData.parse("25/05/2023"), sdfHora.parse("16:00"), new pacienteDTO(bob));
		
		agendaRepositorio.saveAll(Arrays.asList(data1, data2));
	}
	
}
