package br.edu.ifrn.modelo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Diretoria;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Usuario;

public class OfertaEstagioDAO extends DAO {
	public List<OfertaEstagio> findByDiretoria(String sigla) throws DatabaseException {
		Session session = sf.openSession();
		List<OfertaEstagio> lista = null;

		try {
			Query query = session.createQuery("from OfertaEstagio where diretoria.sigla = :sigla");
			query.setParameter("sigla", sigla);
			if (query.list().size() != 0)
				lista = query.list();				
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("Falha na busca");
		} finally {
			session.close();
		}
		
		return lista;
	}
}
