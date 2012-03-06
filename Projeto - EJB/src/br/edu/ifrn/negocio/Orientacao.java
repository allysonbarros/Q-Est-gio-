package br.edu.ifrn.negocio;

import java.io.Serializable;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Orientacao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	private Estagio estagio;
	
	@OneToMany
	private Orientador orientador;
	
	public Orientacao(){
		
	}
	
	public void setEstagio(Estagio estagio) {
		this.estagio = estagio;
	}
	public Estagio getEstagio() {
		return estagio;
	}
	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
	public Orientador getOrientador() {
		return orientador;
	}
	

}
