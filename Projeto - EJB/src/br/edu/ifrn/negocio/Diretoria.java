package br.edu.ifrn.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="DIRETORIA_SeqGen", sequenceName="DIRETORIA_GEN_VAL")
public class Diretoria implements Serializable {	
	private static final long serialVersionUID = -1913019698608405151L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIRETORIA_SeqGen")
	private Long id;
	
	@Column(unique=true)
	private String nome;
	
	@Column(unique=true)
	private String sigla;

	@OneToMany(mappedBy="diretoria",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Curso> cursos;
	
	@OneToMany(mappedBy="diretoria",cascade=CascadeType.ALL)
	private List<Orientador> orientadores;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private InstituicaoEnsino instituicaoEnsino;
	
	public Diretoria() {
		
	}
	
	public Diretoria(String nome, String sigla, List<Curso> cursos,
			InstituicaoEnsino instituicaoEnsino) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.cursos = cursos;
		this.instituicaoEnsino = instituicaoEnsino;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public InstituicaoEnsino getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public List<Orientador> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(List<Orientador> orientadores) {
		this.orientadores = orientadores;
	}
	
	@Override	
	public String toString() {
		return this.sigla + " - " + this.nome;
	}

}
