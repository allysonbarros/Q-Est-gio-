package br.edu.ifrn.negocio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="EMPRESA_SeqGen", sequenceName="EMPRESA_GEN_VAL")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 6666162512956942598L;
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPRESA_SeqGen")
	private Long id;
	
	@Column(unique=true)
	private String cnpj;
	
	private String razaoSocial;
	private String nomeFantasia;
	private String email;
	private String emailAlternativo;
	private String site;
	private String nomeResponsavel;
	private String cargoResponsavel;
	private String areaAtuacao;
	private int numeroFuncionarios;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="usuario_id")
//	private Usuario usuario;
	
	public Empresa() {
		
	}
	
	public Empresa(Long id, String cnpj, String razaoSocial, String nomeFantasia,
			String email, String emailAlternativo, String site, String nomeResponsavel,
			String cargoResponsavel, String areaAtuacao,
			int numeroFuncionarios, Endereco endereco) {
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.email = email;
		this.emailAlternativo = emailAlternativo;
		this.site = site;
		this.nomeResponsavel = nomeResponsavel;
		this.cargoResponsavel = cargoResponsavel;
		this.areaAtuacao = areaAtuacao;
		this.numeroFuncionarios = numeroFuncionarios;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEmailAlternativo() {
		return emailAlternativo;
	}

	public void setEmailAlternativo(String emailAlternativo) {
		this.emailAlternativo = emailAlternativo;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getCargoResponsavel() {
		return cargoResponsavel;
	}

	public void setCargoResponsavel(String cargoResponsavel) {
		this.cargoResponsavel = cargoResponsavel;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
}
