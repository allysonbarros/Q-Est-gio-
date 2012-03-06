package br.edu.ifrn.negocio;

import java.io.Serializable;

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

import org.hibernate.annotations.IndexColumn;

@Entity
@SequenceGenerator(name="ESTAGIO_SeqGen", sequenceName="ESTAGIO_GEN_VAL")
public class Estagio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTAGIO_SeqGen")
	private Long id;
	
	@OneToMany(fetch=FetchType.EAGER)
	@IndexColumn(name="INDEX_COL")
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="oferta_id")
	@IndexColumn(name="INDEX_COL")
	private OfertaEstagio ofertaEstagio;
	
	@OneToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	private String funcao;
	private String descricao;
	
	public Estagio(OfertaEstagio ofertaEstagio, Aluno aluno) {
		this.ofertaEstagio = ofertaEstagio;
		this.aluno = aluno;
		this.funcao = ofertaEstagio.getFuncao();
		this.descricao = ofertaEstagio.getDescricao();
	}
	
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
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setOfertaEstagio(OfertaEstagio ofertaEstagio) {
		this.ofertaEstagio = ofertaEstagio;
	}
	public OfertaEstagio getOfertaEstagio() {
		return ofertaEstagio;
	}
	
	
}
