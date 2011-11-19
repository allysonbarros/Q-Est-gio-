package controllers;

import play.*;
import play.mvc.*;

import helpers.Contexto;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifrn.patterns.EnderecoDelegate;

public class Application extends Controller {

    public static void index() throws NamingException {
    	EnderecoDelegate enderecoBean;
		try {
			enderecoBean = new EnderecoDelegate();
			System.out.println(enderecoBean.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}