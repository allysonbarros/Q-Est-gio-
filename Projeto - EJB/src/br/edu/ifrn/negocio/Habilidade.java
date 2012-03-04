package br.edu.ifrn.negocio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="HABILIDADE_SeqGen", sequenceName="HABILIDADE_GEN_VAL")
public class Habilidade implements Serializable{
	private static final long serialVersionUID = -7039304452142611781L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HABILIDADE_SeqGen")
	private Long id;
	
	private String nome;
	private String nivel;
	private int tipoHabilidade;
	
	public Habilidade() {

	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNivel() {
		return nivel;
	}

	public void setTipoHabilidade(int tipoHabilidade) {
		this.tipoHabilidade = tipoHabilidade;
	}

	public int getTipoHabilidade() {
		return tipoHabilidade;
	}

	public enum TipoHabilidade {
		IDIOMA, INFORMATICA, OUTROS_CONHECIMENTOS
	}
}

