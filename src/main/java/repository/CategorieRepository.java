package repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Categorie;
import entity.Utilisateur;
 
public class CategorieRepository {

	private Session session;

	public CategorieRepository() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();

	}
	//ajout
	public void insertCategorie(Categorie categorie) {
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		session.close();
	}
	//lecture
	public List<Categorie> lectureCategorie() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Categorie> criteria = builder.createQuery(Categorie.class);
		criteria.from(Categorie.class);	
		return session.createQuery(criteria).getResultList();	
	}
	
	public Categorie getOne(Long id){
		session.beginTransaction();
		Categorie categorie;
		categorie = session.get(Categorie.class, id);
		session.getTransaction().commit();
		return categorie;
	}
	
	//suppression
	public void supprimerCategorie(Categorie categorie){
		session.beginTransaction();
		session.delete(categorie);
		session.getTransaction().commit();
	}
	
	//modification
	public void modifierCategorie(Categorie categorie){
		session.beginTransaction();
		session.update(categorie);
		session.getTransaction();
	}
}