package com.formation.persitance.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table (name = "paniers")
@Entity
public class TypeDePanier {
	
	@Id
	Long id;
	
	@Column
	String titre;
	
	@Column
	Date debut;
	
	@Column
	Date fin;
	
	@Column
	Float prix;
	
	@Column (name = "qte_dispo")
	Long qteDispo;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_panier")
	List<ProduitDuPanier> produitsDuPanier; 
	
	
	
	

}
