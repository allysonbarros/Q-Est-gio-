package br.edu.ifrn.exceptions;

public class ConnectionException extends Exception {
	public ConnectionException() {
		super("Falha ao conectar-se com o EJB.");
		// TODO Auto-generated constructor stub
	}
	
	public ConnectionException(String message){
		super(message);
	}
}
