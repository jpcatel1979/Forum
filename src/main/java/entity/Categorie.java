package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
	private Long id;

	@Column(name = "nom")
	private String titre;

	@Column(name = "date_creation")
	private Date dateCreation;
	
	@Column(name = "date_update")
	private Date dateUpdate;

	@ManyToOne(targetEntity = Categorie.class)
	@JoinColumn (name="categorie_id")
	private Categorie categorie;
	
	@ManyToOne(targetEntity = Utilisateur.class)
	@JoinColumn (name="utilisateur_id")
	private Utilisateur utilisateur;

	public Categorie(){
		
	}
	
	public Categorie(Long id, String titre, Date dateCreation, Date dateUpdate, Categorie categorie, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}

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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/*public List<Sujet> getSujets() {
		return sujets;
	}

	public void setSujets(List<Sujet> sujets) {
		this.sujets = sujets;
	}*/

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", titre=" + titre + ", dateCreation=" + dateCreation + ", dateUpdate="
				+ dateUpdate + ", categorie=" + categorie + ", utilisateur=" + utilisateur + ", sujets=" + "sujets" + "]";
	}
	
	
}
