package com.formation.persitance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.persitance.entities.PanierCommandable;


public interface IPanierCommandableRepository extends JpaRepository<PanierCommandable, Long> {

}
