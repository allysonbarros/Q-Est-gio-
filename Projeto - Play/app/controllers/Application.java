package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Application extends Controller {

    public static void index() throws NamingException                                                                                                                                                           {
    	InitialContext  jndi = getInitialContext();
    }
    
    private static InitialContext getInitialContext() throws NamingException {
	       Properties env = new Properties();
	       env.put(Context.SECURITY_PRINCIPAL, "guest" );
	       env.put(Context.SECURITY_CREDENTIALS, "guest" );
	       env.put(Context.INITIAL_CONTEXT_FACTORY,    
	"org.jboss.security.jndi.JndiLoginInitialContextFactory");
	       env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
	      return new InitialContext(env);
	}
}