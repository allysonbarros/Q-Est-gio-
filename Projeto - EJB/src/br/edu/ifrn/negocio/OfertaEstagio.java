package br.edu.ifrn.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="OFERTAESTAGIO_SeqGen", sequenceName="OFERTAESTAGIO_GEN_VAL")
public class OfertaEstagio  implements Serializable {
	private static final long serialVersionUID = -1651515689960732974L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFERTAESTAGIO_SeqGen")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	
	@ManyToMany
	@JoinTable(name="oferta_aluno",
	joinColumns={@JoinColumn(name="oferta_id")},
	inverseJoinColumns={@JoinColumn(name="aluno_id")}) 
	private List<Aluno> candidatos;
	
	private int numVagas;
	private String areaConhecimento;
	private String funcao;
	private String descricao;
	
	private Diretoria diretoria;
	private Curso curso;
	
	public OfertaEstagio() {
		
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public String getAreaConhecimento() {
		return areaConhecimento;
	}
	
	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNumVagas() {
		return numVagas;
	}
	
	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}

	public void setCandidatos(List<Aluno> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Aluno> getCandidatos() {
		return candidatos;
	}

	public void setDiretoria(Diretoria diretoria) {
		this.diretoria = diretoria;
	}

	public Diretoria getDiretoria() {
		return diretoria;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	
}
