package br.edu.ifrn.modelo;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Usuario;

public class UsuarioDAO extends DAO {
	public Usuario findByLogin(String login) throws DatabaseException {
		Session session = sf.openSession();
		Usuario u = null;
		
		try {
			Query query = session.createQuery("from Usuario where login = :login");
			query.setParameter("login", login);
			if (query.list().size() != 0)
				u = (Usuario) query.list().get(0);				
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Falha na busca");
		} finally {
			session.close();
		}
		
		return u;
	}
	
	public Usuario findByEmail(String email) throws DatabaseException {
		Session session = sf.openSession();
		Usuario u = null;
		
		try {
			Query query = session.createQuery("from Usuario where email = :email");
			query.setParameter("email", email);
			if (query.list().size() != 0)
				u = (Usuario) query.list().get(0);				
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Falha na busca");
		} finally {
			session.close();
		}
		
		return u;
	}
}