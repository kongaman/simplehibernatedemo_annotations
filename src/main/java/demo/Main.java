package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Book book = new Book("What does this Button do?", "Bruce Dickinson");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		
		System.out.println(book.toString());
		System.out.println("Book record saved succesfully");
	}

}
