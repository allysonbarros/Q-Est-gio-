package br.edu.ifrn.negocio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.IndexColumn;

@Entity
@SequenceGenerator(name="ORIENTACAO_SeqGen", sequenceName="ORIENTACAO_GEN_VAL")
public class Orientacao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORIENTACAO_SeqGen")
	private Long id;
	
	@OneToOne(cascade={CascadeType.ALL})
	@IndexColumn(name="INDEX_COL")
	@JoinColumn(name="estagio_id")
	private Estagio estagio;
	
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="orientador_id")
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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	

}
