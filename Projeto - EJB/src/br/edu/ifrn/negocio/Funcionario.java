package br.edu.ifrn.negocio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue((TipoPessoa.FUNCIONARIO+""))	
public class Funcionario extends Pessoa {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7906550806891499033L;
	/**
	 * 
	 */
	private String teste;
}
