package com.formation;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formation.persitance.entities.Client;
import com.formation.persitance.repositories.IClientRepository;
import com.formation.persitance.repositories.ICommandeRepository;


@SpringBootApplication
public class MonApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(MonApplication.class, args);
	}

	
	@Autowired
	// on câble automatiquement entre ici et l
	private IClientRepository clientRepo;
	
	
	
	@Autowired
	private ICommandeRepository commandeRepo;
	
	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		
//		
//		Client c = new Client();
//		c.setId(9L);
//		c.setNom("musso");
//		c.setPrenom("Pierre");
//		
//		// Créer une date de naissance
//		Calendar ca = Calendar.getInstance();
//		ca.set(Calendar.YEAR, 1978);
//		ca.set(Calendar.MONTH, Calendar.OCTOBER);
//		ca.set(Calendar.DAY_OF_MONTH, 11);
//		// et la récupérer
//		c.setNaissance(ca.getTime());
//			
//		
//		
//		c.setTelephone("118712");
//		c.setEmail("mammo@comm");
//		clientRepo.save(c);
//		
//		//On peut aussi faire (associé à un constructeur dans l'entité) : 
//		// Client c = new Client("Thirion", "Adélie", ca.getTime(), "adelie.t@gmail.com", "0606606");
//		
//		clientRepo.findAll().stream().forEach(cl -> System.out.println(cl.getNom()));
//		commandeRepo.findAll().stream().forEach(co -> System.out.println(co.getId() + " - " + co.getClient()));
//		
//		
//		//clientRepo.deleteById(5L);
	}

		

	
	

}