package controllers;

import java.util.UUID;

import notifiers.Mails;
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
    			session.put("usuarioAtivoID", u.getId());
    			
    			Application.index();
    		} else {
    			flash.error("Matrícula ou Senha Inválida(s). Tente novamente!");
        		login();
    		}
    	}
    }
    
    public static void efetuarLogoff() {
    	session.remove("usuarioAtivoID");
    	Application.index();
    }
    
    public static void esqueciSenha() {
    	render();
    }
    
    public static void resetarSenha(String email) throws Exception {
    	UsuarioDelegate del = new UsuarioDelegate();
    	Usuario u = del.getUsuarioByEmail(email);
    	if (u == null) {
    		flash.error("Email inválido ou não cadastrado. Tente novamente!");
    		esqueciSenha();
    	} else {
    		flash.success("Enviamos uma email para o endereço: %s. " +
					"Nele você receberá as intruções para a redefinição de sua senha", u.getEmail());
    		Mails.esqueciSenha(u);
    		
    		esqueciSenha();
    	}
    }
    
    public static void redefinirSenha(Long id) throws Exception {
    	UsuarioDelegate del = new UsuarioDelegate();
    	Usuario u = del.getUsuario(id);
    	
    	if (u == null) {
    		flash.error("Usuário inválido ou não cadastrado. Tente novamente!");
    		esqueciSenha();
    	} else {
    		String novaSenha = UUID.randomUUID().toString().substring(0, 8);
    		u.setSenha(novaSenha);
    		
    		System.out.println("\n\n\nNova Senha:" + u.getSenha() + "\n\n");
    	
    		del.editarUsuario(u);
    		Mails.resetarSenha(u, novaSenha);
    		
    		flash.success("Enviamos sua nova senha para uma email para o endereço: %s. ", u.getEmail());
    		
    		login();
    	}
    }
}
