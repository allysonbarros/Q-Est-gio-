package br.edu.ifrn.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import br.edu.ifrn.beans.EmpresaBeanRemote;
import br.edu.ifrn.beans.EnderecoBeanRemote;
import br.edu.ifrn.beans.EstagioBeanRemote;
import br.edu.ifrn.beans.OfertaEstagioBeanRemote;
import br.edu.ifrn.beans.PessoaBeanRemote;
import br.edu.ifrn.beans.UsuarioBeanRemote;

public class ServiceLocator {

	private Context ctx;
	private Map<String, Object> cache;
	private static ServiceLocator instance;
	
	public static ServiceLocator getInstace(){
		if(instance == null){
			instance = new ServiceLocator();
		}
		return instance;
	}
	private ServiceLocator(){
		try{
			ctx = getInitialContext();
			cache = new HashMap<String, Object>();
		}catch(NamingException ne){
			ne.printStackTrace();
			}
	}

	public static InitialContext getInitialContext() throws NamingException {
		Properties env = new Properties();
		env.put(Context.SECURITY_PRINCIPAL, "guest" );
		env.put(Context.SECURITY_CREDENTIALS, "guest" );
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.JndiLoginInitialContextFactory");
		env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		return new InitialContext(env);
	}
	
	public EnderecoBeanRemote getEnderecoBean(){
		Object ref = getService("EnderecoBean/remote");
		EnderecoBeanRemote beanRemote = (EnderecoBeanRemote) PortableRemoteObject.narrow(ref, EnderecoBeanRemote.class);
		return beanRemote;
	}
	
	public PessoaBeanRemote getPessoaBean(){
		Object ref = getService("PessoaBean/remote");
		PessoaBeanRemote beanRemote = (PessoaBeanRemote) PortableRemoteObject.narrow(ref, PessoaBeanRemote.class);
		return beanRemote;
	}
	
	public UsuarioBeanRemote getUsuarioBean(){
		Object ref = getService("UsuarioBean/remote");
		UsuarioBeanRemote beanRemote = (UsuarioBeanRemote) PortableRemoteObject.narrow(ref, UsuarioBeanRemote.class);
		return beanRemote;
	}
	
	public EmpresaBeanRemote getEmpresaBean(){
		Object ref = getService("EmpresaBean/remote");
		EmpresaBeanRemote beanRemote = (EmpresaBeanRemote) PortableRemoteObject.narrow(ref, EmpresaBeanRemote.class);
		return beanRemote;
	}

	public EstagioBeanRemote getEstagioBean(){
		Object ref = getService("EstagioBean/Remote");
		EstagioBeanRemote beanRemote = (EstagioBeanRemote) PortableRemoteObject.narrow(ref, EmpresaBeanRemote.class);
		return beanRemote;
	}
	public OfertaEstagioBeanRemote getOfertaEstagioBean(){
		Object ref = getService("OfertaEstagioBean/remote");
		OfertaEstagioBeanRemote beanRemote = (OfertaEstagioBeanRemote) PortableRemoteObject.narrow(ref, OfertaEstagioBeanRemote.class);
		return beanRemote;
	}
	
	private Object getService(String serviceId){
		if(cache.containsKey(serviceId)){
			return cache.get(serviceId);
		}
			Object service  = null;
			
			try {
				service = ctx.lookup(serviceId);
				cache.put(serviceId, service);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			return service;
	}
}
