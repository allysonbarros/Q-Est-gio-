package controllers;

import java.security.NoSuchAlgorithmException;

import helpers.Contexto;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import play.mvc.Controller;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.Usuario;
import br.edu.ifrn.patterns.EnderecoDelegate;
import br.edu.ifrn.patterns.PessoaDelegate;

public class Usuarios extends Controller {

    public static void index() {
        render();
    }
    
    public static void formCadastro() {
    	render();
    }
    
    public static void cadastrar(Pessoa p) throws Exception {   	
    	PessoaDelegate del = new PessoaDelegate();
    	del.cadastrarPessoa(p);
    	
    	index();
    }

}
