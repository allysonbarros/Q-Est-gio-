package controllers;

import notifiers.Mails;
import play.mvc.Controller;

public class Contato extends Controller {
	public static void index() {
		formContato();
	}

	public static void formContato() {
		render();
	}
	
	public static void enviarContato(String nome, String email, String mensagem) {
		validation.required(nome).message("O campo Nome deve ser preenchido.");
		validation.required(email).message("O campo Nome deve ser preenchido.");
		validation.email("ema_ema", email).message("O Email informado não é válido.");
		validation.required(mensagem).message("O campo Nome deve ser preenchido.");
		
		if(validation.hasErrors()) {
			flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");
			
			renderArgs.put("nome", nome);
			renderArgs.put("email", email);
			renderArgs.put("mensagem", mensagem);
			
			renderTemplate("Contato/formCadastro.html");
		}
		
		Mails.enviarContato(nome, email, mensagem);
		formContato();
	}
}
