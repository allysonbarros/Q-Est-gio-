package br.edu.ifrn.modelo;

import java.util.List;

import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Pessoa;

public class PessoaDAO extends DAO {
	
	public void cadastrarPessoa(Pessoa p) {
		this.save(p);
	}
	
	public List <Pessoa> listarTodosPessoas(){
		return this.findAll(Pessoa.class);
	}
	
	public Endereco findById(long id){
		return this.findById(Pessoa.class, id);
	}
}