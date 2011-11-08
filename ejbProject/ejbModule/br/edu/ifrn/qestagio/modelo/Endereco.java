package br.edu.ifrn.qestagio.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;
	public String logradouro;
	public String complemento;
	public String numero;
	public String bairro;
	public String cidade;
	public String uf;
	public String cep;
}
