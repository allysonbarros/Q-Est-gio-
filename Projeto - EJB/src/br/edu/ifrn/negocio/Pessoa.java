package br.edu.ifrn.negocio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	public Long matricula;
	public String cpf;
	public String rg;
	public String nome;
	public Date dataNascimento;
	public String email;
	public String nomePai;
	public String nomeMae;
	
	public int tipoPessoa;
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	public Endereco endereco;
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	public Usuario usuario;
	
}
