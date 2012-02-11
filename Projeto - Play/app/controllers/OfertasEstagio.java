package controllers;

import helpers.SessionsHelper;

import java.util.List;

import play.mvc.Controller;
import play.mvc.With;
import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.patterns.EmpresaDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;
import br.edu.ifrn.patterns.AlunoDelegate;

@With(SessionsHelper.class)
public class OfertasEstagio extends Controller {

	public static void index() {
		render();
	}

	public static void formCadastro() {
		try {
			EmpresaDelegate del = new EmpresaDelegate();
			List<Empresa> empresas = del.getTodasEmpresas();
			render(empresas);
		} catch (Exception e) {
			error(e.getMessage());
		}
	}

	public static void cadastrar(OfertaEstagio o, long idEmpresa) {
		validation.required("area",o.getAreaConhecimento());
		validation.required("descr",o.getDescricao());
		validation.required("empresa",idEmpresa);
		validation.required("funcao",o.getFuncao());
		validation.required("numvagas", o.getNumVagas());

		if (validation.hasErrors()) {
			flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");
			validation.keep();
			formCadastro();
		} else {
			try{
				OfertaEstagioDelegate del = new OfertaEstagioDelegate();
				EmpresaDelegate del_empresa = new EmpresaDelegate();
				Empresa e = del_empresa.getEmpresa(idEmpresa);
				o.setEmpresa(e);
				del.cadastrarOfertaEstagio(o);
			} catch (Exception er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
				flash.error("<strong>Erro:</strong> " + er.getMessage());
				renderArgs.put("o", o);
				renderTemplate("OfertasEstagio/formCadastro.html");
			}
			
			flash.success("Oferta de estágio cadastrada com sucesso!");
			formCadastro();
		}
	}

	public static void candidatarAluno(long idOferta ) throws Exception{
		long alunoId = Long.parseLong(session.get("usuarioAtivoID"));
		OfertaEstagioDelegate del_oe = new OfertaEstagioDelegate();
		del_oe.inserirCandidato(idOferta, alunoId);
		Application.ofertaEstagio();
	}

	public static void descandidatarAluno(long idOferta ) throws Exception{
		long alunoId = Long.parseLong(session.get("usuarioAtivoID"));
		OfertaEstagioDelegate del_oe = new OfertaEstagioDelegate();
		del_oe.removerCandidato(idOferta, alunoId);
		Application.ofertaEstagio();
	}
}