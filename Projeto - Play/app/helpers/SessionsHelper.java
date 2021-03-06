package helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import controllers.Application;
import controllers.Sessions;

import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.negocio.Usuario;
import br.edu.ifrn.patterns.UsuarioDelegate;

import play.libs.Crypto;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Scope;
import play.mvc.With;
import play.mvc.Scope.Session;

public class SessionsHelper extends Controller {
	@Before(unless={
			"Application.index", "Application.sobre", "Application.informacoesEstagio", "Application.legislacaoNormas", "Application.modelosFormularios", "Application.modeloDeclaracaoEstagio",
			"Sessions.login", "Sessions.efetuarLogin", "Sessions.esqueciSenha", "Sessions.resetarSenha", "Sessions.redefinirSenha"
			//	, "Alunos.formCadastro", "Alunos.cadastrar"
	})
	public static void checkAuthentication() throws Exception {
		if (session.get("usuarioAtivoID") == null) {
			flash.put("url", "GET".equals(request.method) ? request.url : "/");
			Sessions.login();
		}

		Permissao check = getActionAnnotation(Permissao.class);
		if(check != null) {
			try {
				permissao(check);
			} catch (Throwable e) {
				flash.error("<strong>Atenção:</strong> Você não tem permissão para acessar a página solicitada.");
				Application.index();
			}
		}

	}

	private static void permissao(Permissao check) throws Throwable {
		for(String profile : check.value()) {
			boolean hasProfile = permissaoImpl(profile);
			if(!hasProfile) {
				throw new Exception();
			}
		}
	}

	private static boolean permissaoImpl(String profile) throws Exception{
		UsuarioDelegate del = new UsuarioDelegate();
		
		Usuario u = del.getUsuario(Long.parseLong(session.get("usuarioAtivoID")));
		if (profile.equals("administrador") && (u.getTipoUsuario() == TipoPessoa.ADMINISTRADOR)){
			return true;
		}
		if (profile.equals("funcionario") && (u.getTipoUsuario() == TipoPessoa.FUNCIONARIO || u.getTipoUsuario() == TipoPessoa.ADMINISTRADOR)){
			return true;
		}
		if (profile.equals("aluno") && u.getTipoUsuario() == TipoPessoa.ALUNO){
			return true;
		}
		if (profile.equals("orientador") && u.getTipoUsuario() == TipoPessoa.ORIENTADOR){
			return true;
		}
		return false;
	}

	@Before(unless={"Sessions.login", "Sessions.logout"})
	public static void getInfoUsuario() throws Exception {
		if (session.get("usuarioAtivoID") != null) {
			UsuarioDelegate del = new UsuarioDelegate();
			Usuario u = del.getUsuario(Long.parseLong(session.get("usuarioAtivoID")));

			renderArgs.put("currentUsuario", u);
		}
	}

	public static String criptografarSenha(String senha) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(senha.getBytes(), 0, senha.length());
		return new BigInteger(1, digest.digest()).toString(16);
	}
}
