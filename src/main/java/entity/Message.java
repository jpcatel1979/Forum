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
@Table(name = "message")
public class Message {

	@Id
	private Long id;
	
	@Column
	private String texte;

	@Column(name = "date_creation")
	private Date dateCreation;
	
	@Column(name = "date_update")
	private Date dateUpdate;
	
	@ManyToOne(targetEntity = Sujet.class)
	@JoinColumn (name="sujet_id")
	private Sujet sujet;

	@ManyToOne(targetEntity = Utilisateur.class)
	@JoinColumn (name="utilisateur_id")

	private Utilisateur utilsateur;

	public Message() {
		super();
	}

	public Message(Long id, String texte, Date dateCreation, Date dateUpdate, Sujet sujet, Utilisateur utilsateur) {
		super();
		this.id = id;
		this.texte = texte;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.sujet = sujet;
		this.utilsateur = utilsateur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
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

	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}

	public Utilisateur getUtilsateur() {
		return utilsateur;
	}

	public void setUtilsateur(Utilisateur utilsateur) {
		this.utilsateur = utilsateur;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", texte=" + texte + ", dateCreation=" + dateCreation + ", dateUpdate="
				+ dateUpdate + ", Sujet=" + sujet + ", Utilsateur=" + utilsateur + "]";
	}	
}
