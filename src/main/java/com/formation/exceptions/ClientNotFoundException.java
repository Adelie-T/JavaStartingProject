package com.formation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException { //runtime est une sous classe d'Exception qui précise que c'est une erreur locale 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	//ça ne sert à rien (car on ne s'en sert pas) mais il faut le mettre pour ne plus avoir de warning 

	public ClientNotFoundException(String message) { //on met un constructeur (??)
		super(message);
	}
	
}
