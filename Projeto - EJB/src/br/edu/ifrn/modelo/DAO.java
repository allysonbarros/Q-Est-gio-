package br.edu.ifrn.modelo;

import java.util.List;

import javax.ejb.Singleton;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Singleton
public class DAO {
	static SessionFactory sf;
	
	public DAO() {
			sf = new Configuration().configure("/br/edu/ifrn/conf/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public <T> void save(T object) {
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
	
	public <T> void delete(T object) {
		Session session = sf.openSession();
		try {
			session.getTransaction().begin();
			session.delete(object);  
			session.getTransaction().commit();
		
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class classe) {
		List<T> lista = null;
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from "+ classe.getName());
		    lista =  query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public <T> T findById(Class classe, long id){
		Object objeto =null;
		
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from "+ classe.getName() + " where id = :id");
			query.setParameter("id", id);
		    objeto = query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return (T) objeto;
		
	}
}
