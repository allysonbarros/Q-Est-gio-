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
    
    public static void cadastrar_teste() throws Exception {
    	PessoaDelegate del = new PessoaDelegate();
    	
    	Endereco e = new Endereco();
		e.setLogradouro("Rua Santa Luzia");
		e.setNumero("101");
		e.setBairro("Quintas");
		e.setCidade("Natal");
		e.setUf("RN");
		e.setCep("59035-186");
		
		Pessoa p = new Pessoa();
		p.nome = "Allyson Barros";
		p.endereco = e;
		try {
			p.usuario = new Usuario(p, "allysonbarros", "1234", true);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		del.cadastrarPessoa(p);
    }
    
    public static void cadastrar(Pessoa p) throws Exception {   	
    	PessoaDelegate del = new PessoaDelegate();
    	del.cadastrarPessoa(p);
    	
    	index();
    }

}
