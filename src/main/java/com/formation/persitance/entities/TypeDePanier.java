package com.formation.persitance.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table (name = "paniers")
@Entity
public class TypeDePanier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	Set<ProduitDuPanier> produitsDuPanier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Long getQteDispo() {
		return qteDispo;
	}

	public void setQteDispo(Long qteDispo) {
		this.qteDispo = qteDispo;
	}

	public Set<ProduitDuPanier> getProduitsDuPanier() {
		return produitsDuPanier;
	}

	public void setProduitsDuPanier(Set<ProduitDuPanier> produitsDuPanier) {
		this.produitsDuPanier = produitsDuPanier;
	}

	@Override
	public String toString() {
		return "TypeDePanier [id=" + id + ", titre=" + titre + ", debut=" + debut + ", fin=" + fin + ", prix=" + prix
				+ ", qteDispo=" + qteDispo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeDePanier other = (TypeDePanier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
	
	public TypeDePanier() {
		id = null;
		titre = "";
		debut = new java.util.Date();
		fin = new java.util.Date();
		prix = null;
		qteDispo = null;
		produitsDuPanier = null; 
		
	}
	
	

}
