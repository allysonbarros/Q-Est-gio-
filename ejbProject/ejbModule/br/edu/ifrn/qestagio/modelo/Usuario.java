package br.edu.ifrn.qestagio.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;
	
	@OneToOne(mappedBy="usuario")
	private Pessoa pessoa;
	
	public String login;
	public String senha;
	public boolean ativado;
	
	public Usuario(Pessoa pessoa, String login, String senha, boolean ativado) throws NoSuchAlgorithmException {
		this.pessoa = pessoa;
		this.login = login;
		this.criptografarSenha(senha);
		this.ativado = ativado;
	}

	private void criptografarSenha(String senha) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
	    digest.update(senha.getBytes(), 0, senha.length());
	    this.senha = new BigInteger(1, digest.digest()).toString(16);
	}
	
}