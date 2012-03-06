package notifiers;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import play.mvc.Mailer;
import br.edu.ifrn.negocio.Usuario;

public class Mails extends Mailer {
	
	public static void esqueciSenha(Usuario usuario) {
		setSubject("[QEstágio!] Solicitação de alteração de senha!");
		addRecipient(usuario.getEmail());
		setFrom("QEstágio! <no-reply@qestagio.ifrn.edu.br>");
		
		send(usuario);
	}
	
	public static void resetarSenha(Usuario usuario, String novaSenha) throws NoSuchAlgorithmException {
		setSubject("[QEstágio!] Sua senha foi resetada!");
		addRecipient(usuario.getEmail());
		setFrom("QEstágio! <no-reply@qestagio.ifrn.edu.br>");
		
		send(usuario, novaSenha);
	}
	
	public static void enviarContato(String nome, String email, String mensagem) {
		setSubject("[QEstágio!] " + nome  + " entrou em contato.");
		addRecipient("no-reply@qestagio.ifrn.edu.br");
		setFrom(email);
		
		send(nome, email, mensagem);
	}
}
