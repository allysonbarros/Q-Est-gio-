package br.edu.ifrn.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="OFERTAESTAGIO_SeqGen", sequenceName="OFERTAESTAGIO_GEN_VAL")
public class OfertaEstagio  implements Serializable {
	private static final long serialVersionUID = -1651515689960732974L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OFERTAESTAGIO_SeqGen")
	private Long id;
	
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinColumn(name="pessoa_id")
	private List<Pessoa> candidatos;
	private int numVagas;
	private String areaConhecimento;
	private String funcao;
	private String descricao;
	
	public OfertaEstagio() {
		candidatos = new ArrayList<Pessoa>();
		// TODO Auto-generated constructor stub
	}
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
	public int getNumVagas() {
		return numVagas;
	}
	public void setNumVagas(int numVagas) {
		this.numVagas = numVagas;
	}
	
	
}
