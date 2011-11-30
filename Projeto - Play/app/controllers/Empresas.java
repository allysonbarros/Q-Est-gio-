package controllers;

import helpers.SessionsHelper;
import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.patterns.EmpresaDelegate;
import play.mvc.*;

@With(SessionsHelper.class)
public class Empresas extends Controller {

    public static void index() {
        render();
    }
    
    public static void formCadastro() {
    	render();
    }
    
    public static void cadastrar(Empresa e, String confirmacaoSenha) throws Exception {     	
    	validation.required("cnpj", e.getCnpj());
    	
    	if (validation.hasErrors()) {
    		validation.keep();
    		formCadastro();
    	} else {
    		EmpresaDelegate del = new EmpresaDelegate();
        	del.cadastrarEmpresa(e);
        	
        	index();
    	}
    }
    
}
