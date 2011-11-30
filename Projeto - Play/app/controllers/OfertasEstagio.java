package controllers;

import java.util.List;

import play.mvc.Controller;
import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.patterns.EmpresaDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;

public class OfertasEstagio extends Controller {

	public static void index() {
		render();
	}

	public static void formCadastro() throws Exception {
		EmpresaDelegate del = new EmpresaDelegate();
		List<Empresa> empresas = del.getTodasEmpresas();
		render(empresas);
	}

	public static void cadastrar(OfertaEstagio o, long idEmpresa) throws Exception {
		validation.required("area",o.getAreaConhecimento());
		validation.required("descr",o.getDescricao());
		validation.required("empresa",idEmpresa);
		validation.required("funcao",o.getFuncao());
		validation.required("numvagas", o.getNumVagas());

		if (validation.hasErrors()) {
			validation.keep();
			formCadastro();
		} else {
			OfertaEstagioDelegate del = new OfertaEstagioDelegate();
			EmpresaDelegate del_empresa = new EmpresaDelegate();
			Empresa e = del_empresa.getEmpresa(idEmpresa);
			o.setEmpresa(e);
			del.cadastrarOfertaEstagio(o);

			flash.success("Oferta de estágio cadastrada com sucesso!");
			formCadastro();
		}

	}
}