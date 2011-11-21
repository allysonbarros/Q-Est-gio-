package controllers;

import helpers.Contexto;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifrn.beans.EnderecoBeanRemote;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.patterns.EnderecoDelegate;
import br.edu.ifrn.patterns.ServiceLocator;

import play.mvc.Controller;

public class Application extends Controller {

    public static void index() throws Exception {
    	render();
    }
    
}