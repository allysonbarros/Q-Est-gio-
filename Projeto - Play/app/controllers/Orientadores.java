package controllers;

import helpers.SessionsHelper;

import java.security.NoSuchAlgorithmException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Orientador;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.negocio.Usuario;
import br.edu.ifrn.patterns.EnderecoDelegate;
import br.edu.ifrn.patterns.AlunoDelegate;
import br.edu.ifrn.patterns.OrientadorDelegate;

@With(SessionsHelper.class)
public class Orientadores extends Controller {

    public static void index() {
        render();
    }
    
    public static void formCadastro() {
    	renderTemplate("formsGenericos/formCadastroPessoa.html");
    }
    
    public static void cadastrar(Orientador pessoa, String confirmacaoSenha) {
    	validation.required("matr",pessoa.getMatricula()).message("O campo matrícula deve ser preenchido com 12 dígitos.");
    	validation.required("cpf",pessoa.getCpf()).message("O campo CPF deve ser preenchido.");
//    	validation.required("rg",p.getRg());
    	validation.required("nome",pessoa.getNome()).message("O campo Nome deve ser preenchido.");
    	validation.required("logr",pessoa.getEndereco().getLogradouro()).message("O campo Endereço deve ser preenchido.");
    	validation.required("num",pessoa.getEndereco().getNumero()).message("O campo Número deve ser preenchido.");
    	validation.required("bairro",pessoa.getEndereco().getBairro()).message("O campo Bairro deve ser preenchido.");
    	validation.required("cid",pessoa.getEndereco().getCidade()).message("O campo Cidade deve ser preenchido.");
    	validation.required("uf",pessoa.getEndereco().getUf()).message("O campo Estado deve ser preenchido.");
    	validation.required("cep",pessoa.getEndereco().getCep()).message("O campo CEP deve ser preenchido.");
    	validation.required("ema",pessoa.getUsuario().getEmail()).message("O campo Email deve ser preenchido.");
    	validation.email("ema_ema",pessoa.getUsuario().getEmail()).message("O Email informado não é válido.");
    	validation.required(pessoa.getEstadoCivil()).message("O campo Estado Civil deve ser preenchido.");
    	validation.required(pessoa.getSexo()).message("O campo Sexo deve ser preenchido.");
    	validation.required("mae",pessoa.getNomeMae()).message("O campo Nome da Mãe deve ser preenchido.");
    	validation.required("pai",pessoa.getNomePai()).message("O campo Nome do Pai deve ser preenchido");
//    	validation.required(p.getNomeConjuge());
    	validation.required("senha",pessoa.getUsuario().getSenha()).message("O campo Senha deve ser preenchido");
    	//validation.equals("asd ",p.getUsuario().getSenha(), confirmacaoSenha, confirmacaoSenha);
    	
    	if (validation.hasErrors()) {
    		flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");

    		renderArgs.put("pessoa", pessoa);
    		renderTemplate("formsGenericos/formCadastroPessoa.html");
    	} else {
    		try{
	    	OrientadorDelegate del = new OrientadorDelegate();
	    	pessoa.getUsuario().setLogin(pessoa.getMatricula().toString());
	    	pessoa.getUsuario().setTipoUsuario(TipoPessoa.FUNCIONARIO);
	    	del.cadastrarOrientador(pessoa);
    		} catch (Exception er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
				flash.error("<strong>Erro:</strong> " + er.getMessage());
				
				renderArgs.put("pessoa", pessoa);
				renderTemplate("formsGenericos/formCadastroPessoa.html");
			}
	    	flash.success("Orientador cadastrado com sucesso!");
	    	formCadastro();
    	}
    }

}
