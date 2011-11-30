package br.edu.ifrn.modelo;

import java.util.List;

import br.edu.ifrn.negocio.*;
public class Teste {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		DAO dao = new DAO();
		
		List<Pessoa> lista = dao.findAll(Pessoa.class);
		
		for(Pessoa pessoa: lista){
			System.out.println(pessoa.getNome() + pessoa.getCpf());
		}
	}
}
