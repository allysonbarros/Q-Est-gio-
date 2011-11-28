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
	private Long cnpj;
	
	private String razaoSocial;
	private String nomeFantasia;
	private String emailAlternativo;
	private String site;
	private String nomeResponsavel;
	private String cargoResponsavel;
	private String areaAtuacao;
	private int numeroFuncionarios;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Empresa() {
		
	}
	
	public Empresa(Long id, Long cnpj, String razaoSocial, String nomeFantasia,
			String emailAlternativo, String site, String nomeResponsavel,
			String cargoResponsavel, String areaAtuacao,
			int numeroFuncionarios, Endereco endereco, Usuario usuario) {
		this.id = id;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.emailAlternativo = emailAlternativo;
		this.site = site;
		this.nomeResponsavel = nomeResponsavel;
		this.cargoResponsavel = cargoResponsavel;
		this.areaAtuacao = areaAtuacao;
		this.numeroFuncionarios = numeroFuncionarios;
		this.endereco = endereco;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
