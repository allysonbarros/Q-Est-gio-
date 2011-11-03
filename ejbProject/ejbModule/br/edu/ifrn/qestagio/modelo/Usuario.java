package br.edu.ifrn.qestagio.modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Usuario {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;
	
	@OneToOne(mappedBy="usuario")
	private Pessoa pessoa;
	
	public String login;
	public String senha;
	public boolean ativado;
	
	private void criptografarSenha() throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
	    digest.update(senha.getBytes(), 0, senha.length());
	    this.senha = new BigInteger(1, digest.digest()).toString(16);
	}
}