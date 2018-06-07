import java.util.Date;

import entity.Utilisateur;
import repository.UtilisateurRepository;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = new Utilisateur();
		Date date = new Date();
		utilisateur.setAdmin(true);
		utilisateur.setBan(false);
		utilisateur.setBirthday(date);
		utilisateur.setDateCreation(date);
		utilisateur.setDateUpdate(date);
		utilisateur.setEmail("toto@tt.fr");
		utilisateur.setPassword("padddddssword");
		utilisateur.setPseudo("psddddeudo");
		
		
		UtilisateurRepository dao = new UtilisateurRepository();
	//	dao.insertUtilisateur(utilisateur);		
		System.out.println(dao.getOne("toto@tt.fr"));
		//dao.supprimerUtilisateur(utilisateur);
	}

}
