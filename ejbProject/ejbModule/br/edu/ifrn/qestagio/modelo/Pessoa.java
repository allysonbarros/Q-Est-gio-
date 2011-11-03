package br.edu.ifrn.qestagio.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
	@Id
	public Long id;
	public String cpf;
	public String rg;
	public String nome;
	public Date dataNascimento;
	public String email;
	public String nomePai;
	public String nomeMae;
	public Endereco endereco;
}
