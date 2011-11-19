package controllers;

import play.*;
import play.mvc.*;

import helpers.Contexto;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Application extends Controller {

    public static void index() throws NamingException                                                                                                                                                           {
    	InitialContext jndi = Contexto.getInitialContext();
    }
    
}