package br.edu.ifrn.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="CURSO_SeqGen", sequenceName="CURSO_GEN_VAL")
public class Curso implements Serializable {	
	private static final long serialVersionUID = -1913019698608405151L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CURSO_SeqGen")
	private Long id;
	
	@Column(unique=true)
	private String nome;

	private Diretoria diretoria;
	
	@OneToMany(mappedBy="curso")
	private List<CategoriaEstagio> categoriasEstagio;
	
	@OneToMany(mappedBy="curso")
	private List<CategoriaEstagio> alunos;
	
	
	public Curso() {
		
	}

	public Curso(String nome, Diretoria diretoria) {
		super();
		this.nome = nome;
		this.diretoria = diretoria;
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

	public Diretoria getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(Diretoria diretoria) {
		this.diretoria = diretoria;
	}

	public List<CategoriaEstagio> getCategoriasEstagio() {
		return categoriasEstagio;
	}

	public void setCategoriasEstagio(List<CategoriaEstagio> categoriasEstagio) {
		this.categoriasEstagio = categoriasEstagio;
	}

	public List<CategoriaEstagio> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<CategoriaEstagio> alunos) {
		this.alunos = alunos;
	}
	
}
