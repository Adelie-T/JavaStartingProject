package com.formation.persitance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.persitance.entities.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long>{
	
	

}
