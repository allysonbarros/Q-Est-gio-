package br.edu.ifrn.negocio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="CATEGORIAESTAGIO_SeqGen", sequenceName="CATEGORIAESTAGIO_GEN_VAL")
public class CategoriaEstagio implements Serializable {	
	private static final long serialVersionUID = -1913019698608405151L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIAESTAGIO_SeqGen")
	private Long id;
	
	@Column(unique=true)
	private String nome;
	
	private String descricao;

	@ManyToOne(cascade=CascadeType.ALL)
	private Curso curso;
	
	public CategoriaEstagio() {
		
	}

	public CategoriaEstagio(String nome, String descricao, Curso curso) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
