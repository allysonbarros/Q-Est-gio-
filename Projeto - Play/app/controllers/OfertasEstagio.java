package controllers;

import helpers.SessionsHelper;

import java.util.List;

import play.mvc.Controller;
import play.mvc.With;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Curso;
import br.edu.ifrn.negocio.Diretoria;
import br.edu.ifrn.negocio.Empresa;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.patterns.DiretoriaDelegate;
import br.edu.ifrn.patterns.EmpresaDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;
import br.edu.ifrn.patterns.AlunoDelegate;

@With(SessionsHelper.class)
public class OfertasEstagio extends Controller {

	public static void index() {
		formCadastro();
	}

	public static void formCadastro() {
		try {
			EmpresaDelegate del = new EmpresaDelegate();
			DiretoriaDelegate diretoriaDelegate = new DiretoriaDelegate();
			List<Empresa> empresas = del.getTodasEmpresas();
			List<Diretoria> diretorias = diretoriaDelegate.getTodasDiretorias();
			
			if (empresas.isEmpty()) {
				flash.error("<strong>Atenção:</strong> Não é possível criar ofertas de estágio pois nenhuma empresa está cadastrada!");
				Application.index();
			}
			
			render(empresas, diretorias);
		} catch (Exception e) {
			error(e.getMessage());
		}
	}

	public static void cadastrar(OfertaEstagio o, long idEmpresa) {
		validation.required("area",o.getAreaConhecimento());
		validation.required("descr",o.getDescricao());
		validation.required("empresa",idEmpresa).message("Você deve selecionar uma empresa.");
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
		System.out.println(alunoId+"  "+idOferta);
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
	
	public static void getCursosByDiretoria(long idDiretoria) throws Exception {
		DiretoriaDelegate diretoriaDelegate = new DiretoriaDelegate();
		List<Curso> cursos = diretoriaDelegate.getDiretoria(idDiretoria).getCursos();
		render(cursos);
	}
	
    public static void getDadosEmpresa(Long id) {
    	try{
    		EmpresaDelegate del = new EmpresaDelegate();
    		Empresa e = del.getEmpresa(id);
    		StringBuilder sb = new StringBuilder();
    		
    		sb.append("<br/><h4>Confirmação dos dados da empresa escolhida:</h4>");
    		sb.append("<strong>Razão Social: </strong>" + e.getRazaoSocial() + "<br/>");
    		sb.append("<strong>Nome Fantasia: </strong>" + e.getNomeFantasia() + "<br/>");
    		sb.append("<strong>Área de Atuação: </strong>" + e.getAreaAtuacao() + "<br/>");
    		sb.append("<strong>Nome do Responsável: </strong>" + e.getNomeResponsavel() + "<br/>");
    		
    		renderText(sb.toString());
    	} catch (Exception er) {
    		renderText("ERRO: " + er.getLocalizedMessage());
    	}
    }
}