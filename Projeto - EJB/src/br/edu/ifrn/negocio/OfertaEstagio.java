package br.edu.ifrn.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="OFERTAESTAGIO_SeqGen", sequenceName="OFERTAESTAGIO_GEN_VAL")
public class OfertaEstagio  implements Serializable {
	private static final long serialVersionUID = -1651515689960732974L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFERTAESTAGIO_SeqGens")
	private Long id;
	
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	private List<Pessoa> candidatos;
	private String areaConhecimento;
	private String funcao;
	private String descricao;
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Pessoa> getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(List<Pessoa> candidatos) {
		this.candidatos = candidatos;
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
	
	
}
