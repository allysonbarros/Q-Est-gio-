package br.edu.ifrn.exceptions;

public class DatabaseException extends Exception {
	public DatabaseException() {
		super("Falha ao realizar transa��o");
		// TODO Auto-generated constructor stub
	}
	
	public DatabaseException(String message){
		super(message);
	}
}
