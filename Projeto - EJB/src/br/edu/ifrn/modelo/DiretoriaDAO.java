package br.edu.ifrn.modelo;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Diretoria;
import br.edu.ifrn.negocio.Usuario;

public class DiretoriaDAO extends DAO {
	public Diretoria findBySigla(String sigla) throws DatabaseException {
		Session session = sf.openSession();
		Diretoria d = null;
		
		try {
			Query query = session.createQuery("from Diretoria where sigla = :sigla");
			query.setParameter("sigla", sigla);
			if (query.list().size() != 0)
				d = (Diretoria) query.list().get(0);				
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Falha na busca");
		} finally {
			session.close();
		}
		
		return d;
	}
}
