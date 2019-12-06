package com.formation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.CommandeFull;
import com.formation.services.ICommandeService;

@RestController
@RequestMapping(path = "/commande") //tout ce qu'on écrit dans la classe sera accessible par ce chemin. e chemin doit être unique !! 
public class CommandeController {
	
	@Autowired
	ModelMapper mapper;

	@Autowired
	ICommandeService service; 

	public CommandeController() {
		System.out.println("Hello you !"); // pas besoin de faire une instance le controller le faire pour nous ! 
	}

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public List<CommandeFull> findAll(){ 
		return service.getAll()
				.stream()
				.map(c -> mapper.map(c, CommandeFull.class))
				.collect(Collectors.toList()); 


	}
}
