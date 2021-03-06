package br.edu.ifrn.negocio;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="USUARIO_SeqGen", sequenceName="USUARIO_GEN_VAL")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1709541412674451282L;

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_SeqGen")
	private Long id;
	
	@OneToOne(mappedBy="usuario", cascade=CascadeType.PERSIST)
	private Pessoa pessoa;
	
	@Column(unique=true) 
	private String email;
	
	@Column(unique=true) 
	private String login;
	
	private String senha;
	
	private boolean ativado;
	
	@Column(columnDefinition="int default '3'")
	private int tipoUsuario;
	
	public Usuario() {
		super();
	}

	public Usuario(Pessoa pessoa, String email, String login, String senha, boolean ativado, int tipoUsuario) throws NoSuchAlgorithmException {
		this.pessoa = pessoa;
		this.email = email;
		this.login = login;
		this.criptografarSenha(senha);
		this.ativado = ativado;
		this.tipoUsuario = tipoUsuario;
	}

	private void criptografarSenha(String senha) throws NoSuchAlgorithmException {
		if (senha.equals("") || senha == null)
			return;
		MessageDigest digest = MessageDigest.getInstance("MD5");
	    digest.update(senha.getBytes(), 0, senha.length());
	    this.senha = new BigInteger(1, digest.digest()).toString(16);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws NoSuchAlgorithmException {
		criptografarSenha(senha);
	}

	public boolean isAtivado() {
		return ativado;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}
}
