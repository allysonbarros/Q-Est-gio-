package controllers;

import helpers.SessionsHelper;
import br.edu.ifrn.negocio.Usuario;
import br.edu.ifrn.patterns.UsuarioDelegate;
import play.cache.Cache;
import play.mvc.*;

@With(SessionsHelper.class)
public class Sessions extends Controller {

    public static void index() {
        login();
    }
    
    public static void login() {
    	render();
    }
    
    public static void efetuarLogin(String login, String senha) throws Exception {    	
    	UsuarioDelegate del = new UsuarioDelegate();
    	Usuario u = del.getUsuarioByLogin(login);
    	
    	if (u == null) {
    		flash.error("Matrícula ou Senha Inválida(s). Tente novamente!");
    		login();
    	} else {
    		if (u.getSenha().equals(SessionsHelper.criptografarSenha(senha))) {
    			session.put("usuarioAtivo", u.getId());
    			
    			Application.index();
    		} else {
    			flash.error("Matrícula ou Senha Inválida(s). Tente novamente!");
        		login();
    		}
    	}
    }
    
    public static void efetuarLogout() {
    	session.remove("usuarioAtivo");
    	Application.index();
    }
    
    public static void esqueciSenha() {
    	render();
    }
}
