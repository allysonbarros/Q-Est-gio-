package controllers;

import javax.naming.NamingException;

import play.mvc.Controller;

public class Application extends Controller {

    public static void index() throws NamingException {
    	render();
    }
    
}