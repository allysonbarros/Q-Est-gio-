package controllers;

import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.patterns.EmpresaDelegate;
import play.mvc.*;

public class Empresas extends Controller {

    public static void index() {
        render();
    }
    
    public static void formCadastro() {
    	render();
    }
    
    public static void cadastrar(Empresa e) throws Exception {
    	validation.required(e.getCnpj());
    	
    	if (validation.hasErrors()) {
    		validation.keep();
    		formCadastro();
    	} else {
    		EmpresaDelegate del = new EmpresaDelegate();
        	del.cadastrarEmpresa(e);
    	}
    }
    
}
