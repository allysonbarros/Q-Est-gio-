package controllers;

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
    
    public static void cadastrar() throws Exception {
    	PessoaDelegate pessoaDel = new PessoaDelegate();
    	EnderecoDelegate enderecoDel = new EnderecoDelegate();
    	
    	Endereco e = new Endereco();
		e.setLogradouro("Rua Santa Luzia");
		e.setNumero("101");
		e.setBairro("Quintas");
		e.setCidade("Natal");
		e.setUf("RN");
		e.setCep("59035-186");

		Endereco e2 = enderecoDel.cadastrarEndereco(e);
    	
		Pessoa p = new Pessoa();
		p.nome = "Allyson Barros";
		p.endereco = e2;
		
		pessoaDel.cadastrarPessoa(p);
    	//formCadastro();
    }

}
