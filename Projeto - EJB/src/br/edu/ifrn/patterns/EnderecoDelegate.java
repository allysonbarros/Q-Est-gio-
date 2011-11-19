package br.edu.ifrn.patterns;

import br.edu.ifrn.beans.EnderecoBeanRemote;


public class EnderecoDelegate {

	ServiceLocator locator;
	EnderecoBeanRemote bean;
	
	public EnderecoDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getEnderecoBean();
	} 
}
