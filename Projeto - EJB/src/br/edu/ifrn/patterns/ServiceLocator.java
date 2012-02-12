package br.edu.ifrn.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import br.edu.ifrn.beans.AlunoBeanRemote;
import br.edu.ifrn.beans.CategoriaEstagioBean;
import br.edu.ifrn.beans.CategoriaEstagioBeanRemote;
import br.edu.ifrn.beans.CursoBean;
import br.edu.ifrn.beans.CursoBeanRemote;
import br.edu.ifrn.beans.DiretoriaBean;
import br.edu.ifrn.beans.DiretoriaBeanRemote;
import br.edu.ifrn.beans.EmpresaBeanRemote;
import br.edu.ifrn.beans.EnderecoBeanRemote;
import br.edu.ifrn.beans.EstagioBeanRemote;
import br.edu.ifrn.beans.FuncionarioBeanRemote;
import br.edu.ifrn.beans.InstituicaoEnsinoBean;
import br.edu.ifrn.beans.InstituicaoEnsinoBeanRemote;
import br.edu.ifrn.beans.OfertaEstagioBeanRemote;
import br.edu.ifrn.beans.OrientadorBeanRemote;
import br.edu.ifrn.beans.UsuarioBeanRemote;
import br.edu.ifrn.exceptions.ConnectionException;

public class ServiceLocator {

	private Context ctx;
	private Map<String, Object> cache;
	private static ServiceLocator instance;
	
	public static ServiceLocator getInstace() throws ConnectionException{
		if(instance == null){
			instance = new ServiceLocator();
		}
		return instance;
	}
	
	private ServiceLocator() throws ConnectionException{
		try{
			ctx = getInitialContext();
			cache = new HashMap<String, Object>();
		} catch(NamingException ne){
			ne.printStackTrace();
			throw new ConnectionException("Falha na comunicação com o servidor JBOSS.");
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
	
	public EnderecoBeanRemote getEnderecoBean() throws ConnectionException{
		Object ref = getService("EnderecoBean/remote");
		EnderecoBeanRemote beanRemote = (EnderecoBeanRemote) PortableRemoteObject.narrow(ref, EnderecoBeanRemote.class);
		return beanRemote;
	}
	
	public AlunoBeanRemote getPessoaBean() throws ConnectionException{
		Object ref = getService("AlunoBean/remote");
		AlunoBeanRemote beanRemote = (AlunoBeanRemote) PortableRemoteObject.narrow(ref, AlunoBeanRemote.class);
		return beanRemote;
	}
	
	public UsuarioBeanRemote getUsuarioBean() throws ConnectionException{
		Object ref = getService("UsuarioBean/remote");
		UsuarioBeanRemote beanRemote = (UsuarioBeanRemote) PortableRemoteObject.narrow(ref, UsuarioBeanRemote.class);
		return beanRemote;
	}
	
	public EmpresaBeanRemote getEmpresaBean() throws ConnectionException{
		Object ref = getService("EmpresaBean/remote");
		EmpresaBeanRemote beanRemote = (EmpresaBeanRemote) PortableRemoteObject.narrow(ref, EmpresaBeanRemote.class);
		return beanRemote;
	}

	public EstagioBeanRemote getEstagioBean() throws ConnectionException{
		Object ref = getService("EstagioBean/Remote");
		EstagioBeanRemote beanRemote = (EstagioBeanRemote) PortableRemoteObject.narrow(ref, EmpresaBeanRemote.class);
		return beanRemote;
	}
	
	public OfertaEstagioBeanRemote getOfertaEstagioBean() throws ConnectionException {
			Object ref = getService("OfertaEstagioBean/remote");
			OfertaEstagioBeanRemote beanRemote = (OfertaEstagioBeanRemote) PortableRemoteObject.narrow(ref, OfertaEstagioBeanRemote.class);
			return beanRemote;
	}
	
	private Object getService(String serviceId) throws ConnectionException{
		if(cache.containsKey(serviceId)){
			return cache.get(serviceId);
		}
			Object service  = null;
			
			try {
				service = ctx.lookup(serviceId);
				cache.put(serviceId, service);
			} catch (Exception e) {
				throw new ConnectionException("Falha na comunicação com o servidor JBOSS.");
			}
			return service;
	}
	public AlunoBeanRemote getAlunoBean() throws ConnectionException {
		Object ref = getService("AlunoBean/remote");
		AlunoBeanRemote beanRemote = (AlunoBeanRemote) PortableRemoteObject.narrow(ref, AlunoBeanRemote.class);
		return beanRemote;
	}
	
	public FuncionarioBeanRemote getFuncionarioBean() throws ConnectionException {
		Object ref = getService("FuncionarioBean/remote");
		FuncionarioBeanRemote beanRemote = (FuncionarioBeanRemote) PortableRemoteObject.narrow(ref, FuncionarioBeanRemote.class);
		return beanRemote;
	}
	
	public OrientadorBeanRemote getOrientadorBean() throws ConnectionException {
		Object ref = getService("OrientadorBean/remote");
		OrientadorBeanRemote beanRemote = (OrientadorBeanRemote) PortableRemoteObject.narrow(ref, OrientadorBeanRemote.class);
		return beanRemote;
	}

	public InstituicaoEnsinoBeanRemote getInstituicaoEnsinoBean() throws ConnectionException {
		Object ref = getService("InstituicaoEnsinoBean/remote");
		InstituicaoEnsinoBean beanRemote = (InstituicaoEnsinoBean) PortableRemoteObject.narrow(ref, InstituicaoEnsinoBean.class);
		return beanRemote;
	}
	
	public CategoriaEstagioBeanRemote getCategoriaEstagioBean() throws ConnectionException {
		Object ref = getService("CategoriaEstagioBean/remote");
		CategoriaEstagioBean beanRemote = (CategoriaEstagioBean) PortableRemoteObject.narrow(ref, CategoriaEstagioBean.class);
		return beanRemote;
	}
	
	public DiretoriaBeanRemote getDiretoriaBean() throws ConnectionException {
		Object ref = getService("DiretoriaBean/remote");
		DiretoriaBean beanRemote = (DiretoriaBean) PortableRemoteObject.narrow(ref, DiretoriaBean.class);
		return beanRemote;
	}
	
	public CursoBeanRemote getCursoBean() throws ConnectionException {
		Object ref = getService("CursoBean/remote");
		CursoBean beanRemote = (CursoBean) PortableRemoteObject.narrow(ref, CursoBean.class);
		return beanRemote;
	}
}
