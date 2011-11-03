package br.edu.ifrn.qestagio.modelo;

import javax.persistence.*;

public class Usuario {
	@Id
	public Long id;
	
	@OneToOne(mappedBy="usuario")
	private Pessoa pessoa;
	
	public String login;
	public String senha;
}
