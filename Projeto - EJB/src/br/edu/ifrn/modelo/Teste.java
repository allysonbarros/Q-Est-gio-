package br.edu.ifrn.modelo;

import java.util.List;

import br.edu.ifrn.negocio.*;
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		EnderecoDAO daoe = new EnderecoDAO();
		PessoaDAO dao = new PessoaDAO();
		Endereco e = daoe.findById(10);
		Pessoa e1 = new Pessoa();
		e1.setCpf("01316292479");
		e1.setNome("Sedir");
		e1.setEndereco(e);
		
		dao.cadastrarPessoa(e1);
		
		List<Pessoa> pessoas = dao.listarTodosPessoas();
		for (Pessoa p : pessoas) {
			System.out.println(p.getNome()+" - "+p.getEndereco().getBairro());
		}
		
	
	}
}
