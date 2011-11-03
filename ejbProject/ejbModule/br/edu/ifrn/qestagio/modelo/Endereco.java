package br.edu.ifrn.qestagio.modelo;

import javax.persistence.*;

@Entity
public class Endereco {
	@Id
	public Long id;
	public String logradouro;
	public String complemento;
	public String numero;
	public String bairro;
	public String cidade;
	public String uf;
	public String cep;
}
