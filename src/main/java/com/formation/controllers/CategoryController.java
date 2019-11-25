package com.formation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.persitance.entities.Client;
import com.formation.persitance.repositories.IClientRepository;

@RestController
@RequestMapping(path = "/client") //tout ce qu'on écrit dans la classe sera accessible par ce chemin. e chemin doit être unique !! 
public class CategoryController {

	@Autowired
	IClientRepository repo; //on s'injecte le repository car c'est ui qui communique avec la base. 
	
	public CategoryController() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello !"); // pas besoin de faire une instance le controller le faire pour nous ! 
	}
	
	@RequestMapping(path = "/list2", method = RequestMethod.GET)
	// chemin : on précise liste car on veut la liste des clients
	// méthode : on veut récupérer les clients donc on la nomme GET
	public List<Client> findAll(){ //on rend la liste des client accessible depuis un autre PC
		return repo.findAll() ; 
	
}
}
