package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sujet")
public class Sujet {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titre")
	private String sujet;

	@Column(name = "date_creation")
	private Date dateCreation;
	
	@Column(name = "date_update")
	private Date dateUpdate;
	
	@ManyToOne(targetEntity = Categorie.class)
	@JoinColumn (name="categorie_id")
	private Categorie categorie;
	
	@ManyToOne(targetEntity = Utilisateur.class)
	@JoinColumn (name="utilisateur_id")

	private String utilsateurId;

	public Sujet() {
		super();
	}

	public Sujet(Long id, String sujet, Date dateCreation, Date dateUpdate, Categorie categorie, String utilsateurId) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.categorie = categorie;
		this.utilsateurId = utilsateurId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getUtilsateurId() {
		return utilsateurId;
	}

	public void setUtilsateurId(String utilsateurId) {
		this.utilsateurId = utilsateurId;
	}

	@Override
	public String toString() {
		return "Sujet [id=" + id + ", sujet=" + sujet + ", dateCreation=" + dateCreation + ", dateUpdate=" + dateUpdate
				+ ", categorie=" + categorie + ", utilsateurId=" + utilsateurId + "]";
	}
}
