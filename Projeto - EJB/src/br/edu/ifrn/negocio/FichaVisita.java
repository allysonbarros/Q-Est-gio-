package br.edu.ifrn.negocio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="FICHAVISITA_SeqGen", sequenceName="FICHAVISITA_GEN_VAL")

public class FichaVisita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FICHAVISITA_SeqGen")
	private Long id;
	
	@OneToOne
	private Orientacao orientacao;
	
	private String expectativaEmpresa;
	
	private String trabalhosDesenvolvidos;
	
	private String beneficiosTrabalho;
	
	private String interesseAluno;
	
	public FichaVisita(){
		
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}


	public void setOrientacao(Orientacao orientacao) {
		this.orientacao = orientacao;
	}


	public Orientacao getOrientacao() {
		return orientacao;
	}


	public void setExpectativaEmpresa(String expectativaEmpresa) {
		this.expectativaEmpresa = expectativaEmpresa;
	}


	public String getExpectativaEmpresa() {
		return expectativaEmpresa;
	}


	public void setTrabalhosDesenvolvidos(String trabalhosDesenvolvidos) {
		this.trabalhosDesenvolvidos = trabalhosDesenvolvidos;
	}


	public String getTrabalhosDesenvolvidos() {
		return trabalhosDesenvolvidos;
	}


	public void setBeneficiosTrabalho(String beneficiosTrabalho) {
		this.beneficiosTrabalho = beneficiosTrabalho;
	}


	public String getBeneficiosTrabalho() {
		return beneficiosTrabalho;
	}


	public void setInteresseAluno(String interesseAluno) {
		this.interesseAluno = interesseAluno;
	}


	public String getInteresseAluno() {
		return interesseAluno;
	}

}
