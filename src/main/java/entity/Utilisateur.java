package entity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@NotNull
	private String email;

	@Column(length = 10, nullable = false)
	@NotNull
	private String pseudo;
	
	@Column(name = "mdp")
	@NotNull
	private String password;
	
	@Column(name = "role")
	private Boolean admin;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column
	private Boolean ban;
	
	@Column(name = "date_creation")
	private Date dateCreation;
	
	@Column(name = "date_update")
	private Date dateUpdate;

	public Utilisateur() {

	}

	public Utilisateur(String email, String pseudo, String password, Boolean admin, Date birthday, Boolean ban,
			Date dateCreation, Date dateUpdate) {
		super();
		this.email = email;
		this.pseudo = pseudo;
		this.password = password;
		this.admin = admin;
		this.birthday = birthday;
		this.ban = ban;
		this.dateCreation = dateCreation;
		this.dateUpdate = dateUpdate;
	}

	
	public static String crypter(String passwordToHash) {
        String generatedPassword = null;
        String salt = "gandalf";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getBan() {
		return ban;
	}

	public void setBan(Boolean ban) {
		this.ban = ban;
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

	@Override
	public String toString() {
		return "Utilisateur [email=" + email + ", pseudo=" + pseudo + ", password=" + password + ", admin=" + admin
				+ ", birthday=" + birthday + ", ban=" + ban + ", date_creation=" + dateCreation + ", date_update="
				+ dateUpdate + "]";
	}

}
