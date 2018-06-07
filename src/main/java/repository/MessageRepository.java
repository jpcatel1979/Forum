package repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Message;
 
public class MessageRepository {

	private Session session;

	public MessageRepository() {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();

	}
	//ajout
	public void insertMessage(Message message) {
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
	}
	//lecture
	public List<Message> lectureMessage() {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Message> criteria = builder.createQuery(Message.class);
		criteria.from(Message.class);	
		return session.createQuery(criteria).getResultList();	
	}
	
	//suppression
	public void supprimerMessage(Message message){
		session.beginTransaction();
		session.delete(message);
		session.getTransaction().commit();
	}
	
	//modification
	public void modifierMessage(Message message ){
		session.beginTransaction();
		session.update(message);
		session.getTransaction();
	}
}