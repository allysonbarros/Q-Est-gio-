package br.edu.ifrn.qestagio.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import br.edu.ifrn.qestagio.modelo.Endereco;

public class Dao {
	
	public Dao(){
		
	}
	
	public void inserirEndereco(Endereco endereco){
		SessionFactory sf = new Configuration().
		configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.persist(endereco);
		tx.commit();
	}

}
