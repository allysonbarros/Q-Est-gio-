package controllers;

import helpers.SessionsHelper;

import java.security.NoSuchAlgorithmException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.negocio.Usuario;
import br.edu.ifrn.patterns.EnderecoDelegate;
import br.edu.ifrn.patterns.PessoaDelegate;

@With(SessionsHelper.class)
public class Orientadores extends Controller {

    public static void index() {
        render();
    }
    
    public static void formCadastro() {
    	render();
    }
    
    public static void cadastrar(Pessoa p, String confirmacaoSenha) throws Exception {
    	validation.required("matr",p.getMatricula());
    	validation.required("cpf",p.getCpf());
//    	validation.required("rg",p.getRg());
    	validation.required("nom",p.getNome());
    	validation.required("logr",p.getEndereco().getLogradouro());
    	validation.required("num",p.getEndereco().getNumero());
    	validation.required("bairro",p.getEndereco().getBairro());
    	validation.required("cid",p.getEndereco().getCidade());
    	validation.required("uf",p.getEndereco().getUf());
    	validation.required("cep",p.getEndereco().getCep());
    	validation.required("ema",p.getUsuario().getEmail());
    	validation.email("ema_ema",p.getUsuario().getEmail());
//    	validation.required(p.getEstadoCivil());
//    	validation.required(p.getSexo());
    	validation.required("mae",p.getNomeMae());
    	validation.required("pai",p.getNomePai());
//    	validation.required(p.getNomeConjuge());
    	validation.required("login",p.getUsuario().getLogin());
    	validation.required("senha",p.getUsuario().getSenha());
    	//validation.equals(p.getUsuario().getSenha(), confirmacaoSenha);
    	
    	if (validation.hasErrors()) {
    		flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");
    		validation.keep();
    		formCadastro();
    	} else {
	    	PessoaDelegate del = new PessoaDelegate();
	    	p.getUsuario().setTipoUsuario(TipoPessoa.FUNCIONARIO);
	    	p.getUsuario().setLogin(p.getMatricula().toString());
	    	del.cadastrarPessoa(p);
	    	
	    	flash.success("Orientador cadastrado com sucesso!");
	    	formCadastro();
    	}
    }

}
