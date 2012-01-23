package br.edu.ifrn.negocio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue((TipoPessoa.ALUNO+""))	
public class Aluno extends Pessoa {
	private String teste;
}
