package br.edu.ifrn.modelo;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class DAO {
	static SessionFactory sf;
		
	public static void main(String[] args) {
		DAO dao = new DAO();
	}
	
	public DAO() {
		File f = new File("/Users/allysonbarros/Dropbox/Q-Est‡gio!/Projeto - EJB/src/br/edu/ifrn/conf/hibernate.cfg.xml");
		if (f.exists())
			sf = new Configuration().configure(f).buildSessionFactory();
	}
	
	public static <T> void save(T object) {
		Session session = sf.openSession();
		try {
			
			session.getTransaction().begin();
			session.persist(object);  
			session.getTransaction().commit();
		
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static <T> void delete(T object) {
		Session session = sf.openSession();  
		session.getTransaction().begin();
		session.delete(object);  
		session.getTransaction().commit();
	}
}
