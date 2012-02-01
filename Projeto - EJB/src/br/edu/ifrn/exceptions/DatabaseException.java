package br.edu.ifrn.exceptions;

public class DatabaseException extends Exception {
	public DatabaseException() {
		super("Falha ao realizar transação");
		// TODO Auto-generated constructor stub
	}
	
	public DatabaseException(String message){
		super(message);
	}
}
