package repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Categorie;
import entity.Sujet;
 
public class SujetRepository {

	private Session session;

	public SujetRepository() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();

	}
	//ajout
	public void insertSujet(Sujet sujet) {
		session.beginTransaction();
		session.save(sujet);
		session.getTransaction().commit();
	}
	//lecture
	public List<Sujet> lectureSujet() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Sujet> criteria = builder.createQuery(Sujet.class);
		criteria.from(Sujet.class);	
		return session.createQuery(criteria).getResultList();	
	}
	
	//suppression
	public void supprimerSujet(Sujet sujet){
		session.beginTransaction();
		session.delete(sujet);
		session.getTransaction().commit();
	}
	
	//modification
	public void modifierSujet(Sujet sujet){
		session.beginTransaction();
		session.update(sujet);
		session.getTransaction();
	}
	public Sujet getOne(Long id) {
		session.beginTransaction();
		Sujet sujet;
		sujet = session.get(Sujet.class, id);
		session.getTransaction().commit();
		return sujet;
	}
}