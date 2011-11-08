package br.edu.ifrn.qestagio.teste;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class ServiceLocator {
	
	private Context contexto;
	private Map<String, Object> cache;
	private static ServiceLocator instance;
	
	public static synchronized ServiceLocator getInstace(){
		if(instance ==null){
			instance = new ServiceLocator();
		}
		return instance;
	}
	
	private ServiceLocator(){
		try{
			contexto = getInitialContext();
			cache = new HashMap<String, Object>();
		}
		catch(NamingException ne){
			ne.printStackTrace();
	    }
	}
	
	public br.edu.ifrn.qestagio.bean.EnderecoBeanRemote getEnderecoBean(){
		Object ref = getService("br.edu.ifrn.qestagio.bean.EnderecoBeanRemote/remote");
		br.edu.ifrn.qestagio.bean.EnderecoBeanRemote benRemote = 
			(br.edu.ifrn.qestagio.bean.EnderecoBeanRemote) PortableRemoteObject.narrow(ref, br.edu.ifrn.qestagio.bean.EnderecoBeanRemote.class);
		return benRemote;
	}
	
	private Object getService(String serviceId){
		if(cache.containsKey(serviceId)){
			return cache.get(serviceId);
		}
			Object service  = null;
			
			try {
				service = contexto.lookup(serviceId);
				cache.put(serviceId, service);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			return service;
	}

		

	
	public static InitialContext getInitialContext() throws NamingException {
		Properties env = new Properties();
		env.put(Context.SECURITY_PRINCIPAL, "guest" );
		env.put(Context.SECURITY_CREDENTIALS, "guest" );
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
		env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		return new InitialContext(env);
	}
	
	
	

}
