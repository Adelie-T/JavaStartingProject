package com.formation.persitance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="paniers_to_commandes")
@Entity
public class PanierCommandable {
	
	@Id
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_panier")
	private TypeDePanier typeDePanier; 
	//on crée un attribut typeDePanier qui pour chaque panier commandable récupèrera son type. 

	

}
