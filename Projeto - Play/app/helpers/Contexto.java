package helpers;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Contexto {
	public static InitialContext getInitialContext() throws NamingException {
	       Properties env = new Properties();
	       env.put(Context.SECURITY_PRINCIPAL, "guest" );
	       env.put(Context.SECURITY_CREDENTIALS, "guest" );
	       env.put(Context.INITIAL_CONTEXT_FACTORY,    
	"org.jboss.security.jndi.JndiLoginInitialContextFactory");
	       env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
	      return new InitialContext(env);
	}
}
