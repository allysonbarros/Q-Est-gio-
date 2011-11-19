package controllers;

import play.*;
import play.mvc.*;

import helpers.Contexto;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.patterns.EnderecoDelegate;

public class Application extends Controller {

    public static void index() throws NamingException {
    	EnderecoDelegate enderecoBean;
    	
		try {
			enderecoBean = new EnderecoDelegate();
			System.out.println(enderecoBean.toString());
			
			Endereco e = new Endereco();
			e.setLogradouro("Rua Santa Luzia");
			e.setNumero("101A");
			e.setBairro("Quintas");
			e.setCidade("Natal");
			e.setUf("RN");
			e.setCep("59035-186");
			
			enderecoBean.cadastrarEndereco(e);
			
		} catch (Exception e) {
			error(e);
		}
    }
    
}