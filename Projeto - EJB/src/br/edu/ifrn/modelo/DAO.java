package br.edu.ifrn.modelo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.ifrn.exceptions.DatabaseException;

public class DAO {
	static SessionFactory sf;
	public Session session;
	public DAO() {
			sf = new Configuration().configure("/br/edu/ifrn/conf/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public <T> void save(T object) throws DatabaseException {
		Session session = sf.openSession();
		try {
			
			session.getTransaction().begin();
			session.persist(object);  
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw new DatabaseException("Falha na persistência");
		} finally {
			session.close();
		}
		
	}
	
	public <T> void update(T object) throws DatabaseException {
		Session session = sf.openSession();
		try {
			
			session.getTransaction().begin();
			session.merge(object);  
			session.getTransaction().commit();
		
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw new DatabaseException("Falha na atualização");
		} finally {
			session.close();
		}
	}
	
	public <T> void delete(T object) throws DatabaseException {
		Session session = sf.openSession();
		try {
			session.getTransaction().begin();
			session.delete(object);  
			session.getTransaction().commit();
		
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			throw new DatabaseException("Falha na remoção");
		} finally {
			session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class classe) throws DatabaseException {
		List<T> lista = null;
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from "+ classe.getName());
		    lista =  query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Falha na busca");
		} finally {
			session.close();
		}
		return lista;
	}
	
	public <T> T findById(Class classe, long id) throws DatabaseException {
		Object objeto = null;
		
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from "+ classe.getName() + " where id = :id");
			query.setParameter("id", id);
		    objeto = query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Falha na busca");
		} finally {
			session.close();
		}
		
		return (T) objeto;
		
	}
}
