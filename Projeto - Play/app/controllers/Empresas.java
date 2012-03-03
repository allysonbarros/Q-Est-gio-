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
    public static void cadastrar(Empresa e, String confirmacaoSenha) {     	
    	validation.required("cnpj", e.getCnpj());
    	
    	if (validation.hasErrors()) {
    		flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");
    		validation.keep();
    		formCadastro();
    	} else {
    		try{
    			EmpresaDelegate del = new EmpresaDelegate();
    			del.cadastrarEmpresa(e);
    		} catch (Exception er) {
				// TODO Auto-generated catch block
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
