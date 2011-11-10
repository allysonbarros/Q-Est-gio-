package br.edu.ifrn.modelo;

import java.util.List;

import br.edu.ifrn.negocio.Endereco;

public class EnderecoDAO extends DAO {
	
	public void cadastrarEndereco(Endereco e) {
		this.save(e);
	}
	
	public List <Endereco> listarTodosEnderecos(){
		return this.findAll(Endereco.class);
	}
}