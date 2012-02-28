package br.edu.ifrn.negocio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue((TipoPessoa.ORIENTADOR+""))	
public class Orientador extends Pessoa {
	private static final long serialVersionUID = 2108646997187776609L;
	
	@ManyToOne
	private Diretoria diretoria;

	public Diretoria getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(Diretoria diretoria) {
		this.diretoria = diretoria;
	}
}
