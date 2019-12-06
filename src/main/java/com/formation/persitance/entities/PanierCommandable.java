package com.formation.persitance.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="paniers_to_commandes")
@Entity
public class PanierCommandable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne //à plusieurs paniersCommendables correspondent 1 type de panier
	@JoinColumn(name = "id_panier", referencedColumnName = "id")
	private TypeDePanier typeDePanier; 
	//on crée un attribut typeDePanier qui pour chaque panier commandable récupèrera son type. 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeDePanier getTypeDePanier() {
		return typeDePanier;
	}

	public void setTypeDePanier(TypeDePanier typeDePanier) {
		this.typeDePanier = typeDePanier;
	}

	@Override
	public String toString() {
		return "PanierCommandable [id=" + id + ", typeDePanier=" + typeDePanier + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PanierCommandable other = (PanierCommandable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public PanierCommandable() {
		id = null;
		typeDePanier = null; 
	}

}
