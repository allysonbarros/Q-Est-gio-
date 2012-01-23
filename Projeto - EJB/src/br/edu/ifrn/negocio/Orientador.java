package br.edu.ifrn.negocio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue((TipoPessoa.ORIENTADOR+""))	
public class Orientador extends Pessoa {
	private static final long serialVersionUID = 2108646997187776609L;
	/**
	 * 
	 */
	private String teste;
}
