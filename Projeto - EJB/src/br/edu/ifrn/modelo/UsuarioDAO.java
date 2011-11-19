package br.edu.ifrn.modelo;

import java.util.List;

import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.Usuario;

public class UsuarioDAO extends DAO {
	
	public void cadastrarPessoa(Usuario u) {
		this.save(u);
	}
	
	public List <Usuario> listarTodosUsuarios(){
		return this.findAll(Usuario.class);
	}
	
	public Endereco findById(long id){
		return this.findById(Usuario.class, id);
	}
}