package com.formation.persitance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.persitance.entities.Client;




public interface IClientRepository extends JpaRepository<Client, Long> { //JpaRepository parcourt la base de données
	// On bénéficie du JpaReposititory qui permet de lire et écrire
	// JpaRepository est codé pour tous les types et on lui précise qu'il devra s'adapter à mon type "Client"
	// Il s'adaptera à ce qui existe comme données dans clients.
	
	// Si on veut selctionner qu'une partie de la base de données il vaut mieux mettre le critère directement
	//plutôt que de tout selectionner de la base de données et de trier ensuite pour n'en garder qu'un peu.
	// exemple de trie : les clients commençant par 'A'
	
	@Query(nativeQuery = true, value = "SELECT * FROM clients WHERE name LIKE ?1 OR firstName LIKE ?2") 
	//ici on colle du SQL entre "" car on a choisit de remplir une native Querry
	// ?1 pour le premier paramètre de la fonction (name) et ?2 pour le 2e (firstName) 
	// ici Spring comprend la requête via la query (la ligne de code SQL), on peut écrire en anglais ! 
	public List<Client> findByName(String name, String firstName);
	// quand on lancera la méthode on mettra en paramètre 'A%' pour dire que ça ressemble (like) à un mot qui commence par 'a'
	
	// Sinon on peut faire la demande directement à java (sans SQL) 
	// On écrit la fonction pour que spring la comprenne : la fonction est à rallonge !! 
	// ici on est obligé d'utiliser les attribut tels qu'ils sont dans l'entité (en français) 
	public List<Client> findByNomStartingWithAndPrenomStartingWith(String nom, String prenom);

}
