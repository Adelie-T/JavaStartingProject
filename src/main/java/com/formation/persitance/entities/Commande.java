package com.formation.persitance.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table (name = "commandes")
@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id; 
	
	@Column
	Date date; 
	
	@Column
	Float montant_ht;
	
	@ManyToOne
	// on crée la clé etrangère 
	@JoinColumn(name= "id_clients", referencedColumnName = "Id") 
	// On joint la colonne id_client de la table commande avec la clé primaire de client (demandé ci-dessous)
	// referencedColumnName = "Id" n'est pas nécessaire, c'est automatiquement la clé primaire qui est prise. 
	private Client client ;
	//à chaque commande on crée un client qui récupèrera le client associé à la commande.
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name= "id_commande")
	List<PanierCommandable> panierCommandables;
	//on peut aussi créer une liste mais il s'attend que 

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getMontant_ht() {
		return montant_ht;
	}

	public void setMontant_ht(Float montant_ht) {
		this.montant_ht = montant_ht;
	}



	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + ", montant_ht=" + montant_ht + ", client=" + client + "]";
	}


	

	
	
}
