package br.edu.ifrn.modelo;

import java.util.List;

import br.edu.ifrn.negocio.*;
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EnderecoDAO dao = new EnderecoDAO();
		List<Endereco> enderecos = dao.listarTodosEnderecos();
		for(int i=0; i<enderecos.size(); i++){
			System.out.println(enderecos.get(i).getCidade());
		}
	}

}
