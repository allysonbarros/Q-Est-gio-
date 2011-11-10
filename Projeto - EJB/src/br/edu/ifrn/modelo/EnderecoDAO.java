package br.edu.ifrn.modelo;

import br.edu.ifrn.negocio.Endereco;

public class EnderecoDAO extends DAO {
	public void cadastrarEndereco(Endereco e) {
		this.save(e);
	}
}