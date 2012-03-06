package br.edu.ifrn.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="ESTAGIO_SeqGen", sequenceName="ESTAGIO_GEN_VAL")
public class Estagio {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTAGIO_SeqGen")
	private Long id;
	
	@OneToMany
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	@OneToMany
	@JoinColumn(name="orientador_id")
	private Orientador orientador;
	@OneToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	private String areaConhecimento;
	private String funcao;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
	public Orientador getOrientador() {
		return orientador;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Aluno getAluno() {
		return aluno;
	}
	
	
}
