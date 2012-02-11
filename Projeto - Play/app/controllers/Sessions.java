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
    
    public static void efetuarLogin(String login, String senha) {
    	validation.required(login).message("O campo Login deve ser preenchido.");
    	validation.required(senha).message("O campo Senha deve ser preenchido.");
    	
    	if (validation.hasErrors()) {
    		flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente! <br/><br/>");
    		validation.keep();
    		login();
    	} else {
    		try{
	    		UsuarioDelegate del = new UsuarioDelegate();
	    		Usuario u = del.getUsuarioByLogin(login);
	    	
		    	if (u == null) {
		    		flash.error("Matrícula ou Senha Inválida(s). <br/> Tente novamente!");
		    		login();
		    	} else {
		    		if (u.getSenha().equals(SessionsHelper.criptografarSenha(senha))) {
		    			session.put("usuarioAtivoID", u.getId());
		    			
		    			Application.index();
		    		} else {
		    			flash.error("Matrícula ou Senha Inválida(s). <br/> Tente novamente!");
		        		login();
		    		}
		    	}
    		} catch (Exception er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
				flash.error("<strong>Erro:</strong> " + er.getMessage());
				login();
			}
    	}
    }
    
    public static void efetuarLogoff() {
    	session.remove("usuarioAtivoID");
    	flash("info", "Você foi desconectado do sistema!");
    	login();
    }
    
    public static void esqueciSenha() {
    	render();
    }
    
    public static void resetarSenha(String email) {
    	validation.required(email).message("O campo CPF deve ser preenchido.");
    	validation.email(email).message("O Email informado não é válido.");
    	
    	if (validation.hasErrors()) {
    		validation.keep();
    		esqueciSenha();
    	} else {
    		try{
		    	UsuarioDelegate del = new UsuarioDelegate();
		    	Usuario u = del.getUsuarioByEmail(email);
		    	
		    	if (u == null) {
		    		flash.error("Email inválido ou não cadastrado. <br/> Tente novamente!");
		    		esqueciSenha();
		    	} else {
		    		flash.success("Enviamos uma email para o endereço: %s. " +
							"<br/><br/>Nele você receberá as intruções para a redefinição de sua senha", u.getEmail());
		    		Mails.esqueciSenha(u);
		    		
		    		esqueciSenha();
		    	}
    		} catch (Exception er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
				flash.error("<strong>Erro:</strong> " + er.getMessage());
				esqueciSenha();
			}
    	}
    }
    
    public static void redefinirSenha(Long id) {
    	try{
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
    	
    	} catch (Exception er) {
			// TODO Auto-generated catch block
			er.printStackTrace();
			flash.error(er.getMessage());
			login();
		}
    }
}
