package br.edu.ifrn.negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.IndexColumn;

@Entity
@DiscriminatorValue((TipoPessoa.ALUNO+""))	
public class Aluno extends Pessoa {
	private static final long serialVersionUID = -9151016583503663685L;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToOne
	private Diretoria diretoria;
	
	@OneToMany(mappedBy="aluno",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@IndexColumn(name="INDEX_COL")
	private List<Habilidade> habilidades;
	
	private opcoesPeriodo periodo;
	
	private OpcoesPeriodoAula periodoAula;
	
	public Aluno() {
		
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setDiretoria(Diretoria diretoria) {
		this.diretoria = diretoria;
	}

	public Diretoria getDiretoria() {
		return diretoria;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	
	public void setPeriodo(opcoesPeriodo periodo) {
		this.periodo = periodo;
	}

	public opcoesPeriodo getPeriodo() {
		return periodo;
	}

	public void setPeriodoAula(OpcoesPeriodoAula periodoAula) {
		this.periodoAula = periodoAula;
	}

	public OpcoesPeriodoAula getPeriodoAula() {
		return periodoAula;
	}

	public enum opcoesPeriodo {
		PRIMEIRO, SEGUNDO, TERCEIRO, QUARTO, QUINTO, SEXTO, SETIMO, OITAVO;
	}
	
	public enum OpcoesPeriodoAula {
		MANHA, TARDE, NOITE;
	}
}