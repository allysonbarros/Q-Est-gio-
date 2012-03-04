package controllers;

import helpers.Permissao;
import helpers.SessionsHelper;
import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.patterns.EmpresaDelegate;
import play.mvc.*;

@With(SessionsHelper.class)
public class Empresas extends Controller {

//    public static void index() {
//        render();
//    }
    
	@Permissao("funcionario")
    public static void formCadastro() {
    	render();
    }
    
	@Permissao("funcionario")
    public static void cadastrar(Empresa e) {    
    	validation.required("cnpj", e.getCnpj()).message("O campo CPF deve ser preenchido.");
    	validation.required("razaoSocial", e.getRazaoSocial()).message("O campo Razão Social deve ser preenchido.");
    	validation.required("nomeFantasia", e.getNomeFantasia()).message("O campo Nome Fantasia deve ser preenchido.");
    	validation.required("logr", e.getEndereco().getLogradouro()).message("O campo Endereço deve ser preenchido.");
		validation.required("num", e.getEndereco().getNumero()).message("O campo Número deve ser preenchido.");
		validation.required("bairro", e.getEndereco().getBairro()).message("O campo Bairro deve ser preenchido.");
		validation.required("cid", e.getEndereco().getCidade()).message("O campo Cidade deve ser preenchido.");
		validation.required("uf", e.getEndereco().getUf()).message("O campo Estado deve ser preenchido.");
		validation.required("cep", e.getEndereco().getCep()).message("O campo CEP deve ser preenchido.");
		validation.required("nomeResponsavel", e.getNomeResponsavel()).message("O campo Nome do Responsável deve ser preenchido.");
		validation.required("cargoResponsavel", e.getCargoResponsavel()).message("O campo Cargo do Responsável deve ser preenchido.");
		validation.required("razaoSocial", e.getRazaoSocial()).message("O campo Razão Social deve ser preenchido.");
		validation.required("razaoSocial", e.getRazaoSocial()).message("O campo Razão Social deve ser preenchido.");
		validation.required("email", e.getEmail()).message("O campo Email deve ser preenchido.");
		validation.email("ema_ema", e.getEmail()).message("O Email informado não é válido.");
		
    	if (validation.hasErrors()) {
    		flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");
    		
    		renderArgs.put("e", e);
    		renderTemplate("Empresas/formCadastro.html");
    	} else {
    		try{
    			EmpresaDelegate del = new EmpresaDelegate();
    			del.cadastrarEmpresa(e);
    		} catch (Exception er) {
				er.printStackTrace();
				
				flash.error("<strong>Erro:</strong> " + er.getMessage());
				renderArgs.put("e", e);
				
				renderTemplate("Empresas/formCadastro.html");
			}
    		
        	flash.success("Empresa cadastrada com sucesso!");
	    	formCadastro();
    	}
    }
}
