package controllers;

import helpers.Permissao;
import br.edu.ifrn.negocio.Aluno;
import helpers.SessionsHelper;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;
import br.edu.ifrn.exceptions.ConnectionException;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Diretoria;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Orientacao;
import br.edu.ifrn.negocio.Orientador;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.negocio.Usuario;
import br.edu.ifrn.patterns.DiretoriaDelegate;
import br.edu.ifrn.patterns.EnderecoDelegate;
import br.edu.ifrn.patterns.AlunoDelegate;
import br.edu.ifrn.patterns.FichaVisitaDelegate;
import br.edu.ifrn.patterns.OrientadorDelegate;
import br.edu.ifrn.patterns.PreencherFichaDelegate;

@With(SessionsHelper.class)
public class Orientadores extends Controller {

//    public static void index() {
//        render();
//    }
    
	@Permissao("funcionario")
	public static void formCadastro() throws Exception {
    	DiretoriaDelegate diretoriaDelegate = new DiretoriaDelegate();
		List<Diretoria> diretorias = diretoriaDelegate.getTodasDiretorias();
		
		render(diretorias);
    }
    
	@Permissao("funcionario")
    public static void cadastrar(Orientador p, String confirmacaoSenha, Long idDiretoria) throws Exception {
    	validation.required("matr",p.getMatricula()).message("O campo matrícula deve ser preenchido com 12 dígitos.");
    	validation.required("cpf",p.getCpf()).message("O campo CPF deve ser preenchido.");
//    	validation.required("rg",p.getRg());
    	validation.required("nome",p.getNome()).message("O campo Nome deve ser preenchido.");
    	validation.required("logr",p.getEndereco().getLogradouro()).message("O campo Endereço deve ser preenchido.");
    	validation.required("num",p.getEndereco().getNumero()).message("O campo Número deve ser preenchido.");
    	validation.required("bairro",p.getEndereco().getBairro()).message("O campo Bairro deve ser preenchido.");
    	validation.required("cid",p.getEndereco().getCidade()).message("O campo Cidade deve ser preenchido.");
    	validation.required("uf",p.getEndereco().getUf()).message("O campo Estado deve ser preenchido.");
    	validation.required("cep",p.getEndereco().getCep()).message("O campo CEP deve ser preenchido.");
    	validation.required("ema",p.getUsuario().getEmail()).message("O campo Email deve ser preenchido.");
    	validation.email("ema_ema",p.getUsuario().getEmail()).message("O Email informado não é válido.");
    	validation.required(p.getEstadoCivil()).message("O campo Estado Civil deve ser preenchido.");
    	validation.required(p.getSexo()).message("O campo Sexo deve ser preenchido.");
//    	validation.required("mae",p.getNomeMae()).message("O campo Nome da Mãe deve ser preenchido.");
//    	validation.required("pai",p.getNomePai()).message("O campo Nome do Pai deve ser preenchido");
//    	validation.required(p.getNomeConjuge());
    	validation.required("senha",p.getUsuario().getSenha()).message("O campo Senha deve ser preenchido");
    	//validation.equals("asd ",p.getUsuario().getSenha(), confirmacaoSenha, confirmacaoSenha);
    	
    	if (validation.hasErrors()) {
    		DiretoriaDelegate del2 = new DiretoriaDelegate();
    		flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");

    		renderArgs.put("p", p);
    		renderArgs.put("diretorias", del2.getTodasDiretorias());
    		renderTemplate("Orientadores/formCadastro.html");
    	} else {
    		try {
		    	OrientadorDelegate del = new OrientadorDelegate();
		    	DiretoriaDelegate del2 = new DiretoriaDelegate();
		    	
		    	p.getUsuario().setLogin(p.getMatricula().toString());
		    	p.getUsuario().setTipoUsuario(TipoPessoa.ORIENTADOR);
		    	
		    	p.setDiretoria(del2.getDiretoria(idDiretoria));
		    	
		    	del.cadastrarOrientador(p);
    		} catch (Exception e) {
    			DiretoriaDelegate del2 = new DiretoriaDelegate();
				flash.error("<strong>Erro:</strong> " + e.getMessage());
				
				renderArgs.put("p", p);
				renderArgs.put("diretorias", del2.getTodasDiretorias());
				
				e.printStackTrace();
				
				renderTemplate("Orientadores/formCadastro.html");
			}
    		
	    	flash.success("Orientador cadastrado com sucesso!");
	    	formCadastro();
    	}
    }
	
	public static void preencherFichaVisita(){
		render();
	}
	
	public static void cadastrarFicha(){
		render();
	}
	
	public static void consultarOrientandos() throws ConnectionException, DatabaseException{
		 PreencherFichaDelegate delegate = new PreencherFichaDelegate ();
		List<Orientacao> list = delegate.listarOrientandos();
		List<Aluno> al = new ArrayList<Aluno>();
		long orientadorId = Long.parseLong(session.get("usuarioAtivoID"));
		 for(int i=0; i<list.size(); i++){
			 if(list.get(i).getOrientador().getId()==orientadorId){
				 al.add(list.get(i).getEstagio().getAluno());
			 }
		 }
		render(al);
	}
	
	

}
