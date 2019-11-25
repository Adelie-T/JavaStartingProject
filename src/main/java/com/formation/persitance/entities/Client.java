package com.formation.persitance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table (name = "clients")  //on précise que c'est une table et qu'elle s'appelle "clients" et non 'Client'
@Entity //on précise que c'est une entité (sinon il ne le lira pas)
public class Client {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //précise que l'Id est générée - on précise à spring de ne pas s'nen occuper car elle est gérée par qqn d'autre (la BDA)
	Long id;
	
	@Column
	String nom;
	
	@Column
	String prenom;
	
	@Column (name = "date_naissance") //dans ma base de donnée ça s'appelle 'date_naissance'
	Date naissance;
	
	@Column
	String email;
	
	@Column
	String telephone;
	
	//Il est possible de créer un One to Many, dans ce cas on génère à chaque client une liste de commande
	//Mais on code soit un ManyToOne soit un OneToMany (sinon ça crée des problèmes)
//	@OneToMany(fetch = FetchType.EAGER) 
	// Ici on précise en mode "eager" (avide) car pour un OneToMany le mode par défaut est "lazy" 
	//En EAGER il récupère d'office toutes les données de commande
	//En LAZY il ne les récupère que quand il en a besoin
//	@JoinColumn(name= "id_client", referencedColumnName = "Id")
	//ici on joint les tables sur les même colonnes.
//	List<Commande> commandes; 
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", naissance=" + naissance + ", email="
				+ email + ", telephone=" + telephone + "]";
	}
	
	public Client() {
		super();
	}

	public Client(String nom, String prenom, Date naissance, String email, String telephone) {
		super();
		this.id = null; 
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.email = email;
		this.telephone = telephone;
	}
	
	
	
	

}
