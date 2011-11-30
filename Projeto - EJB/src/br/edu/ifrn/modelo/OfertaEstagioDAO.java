package br.edu.ifrn.modelo;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifrn.negocio.OfertaEstagio;

public class OfertaEstagioDAO extends DAO {
	@Deprecated
	@Override
	public <T> T findById(Class classe, long id) {
		// TODO Auto-generated method stub
		return super.findById(classe, id);
	}
	public OfertaEstagio findById(long id) {
		OfertaEstagio objeto = null;
		Class classe = OfertaEstagio.class;
		Session session = sf.openSession();
		try {
			Query query = session.createQuery("from "+ classe.getName() + " where id = :id");
			query.setParameter("id", id);
		    objeto = (OfertaEstagio) query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return objeto;
		
	}
}