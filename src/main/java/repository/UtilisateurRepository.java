package repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Utilisateur;
 
public class UtilisateurRepository {

	private Session session;

	public UtilisateurRepository() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();

	}
	//ajout
	public void insertUtilisateur(Utilisateur user) {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	//lecture
	public List<Utilisateur> lectureUtilisateur() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> criteria = builder.createQuery(Utilisateur.class);
		criteria.from(Utilisateur.class);	
		return session.createQuery(criteria).getResultList();	
	}
	
	//lecture d'un utilisateur
	public Utilisateur getOne(String email) {
		session.beginTransaction();
		Utilisateur user;
		user = session.get(Utilisateur.class, email);
		session.getTransaction().commit();
		return user;
		
	}
	
	
	//suppression
	public void supprimerUtilisateur(Utilisateur user){
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
	}
	
	//modification
	public void modifierUtilisateur(Utilisateur user){
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
}