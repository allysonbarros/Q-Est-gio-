package controllers;

import helpers.Permissao;
import helpers.SessionsHelper;

import java.util.ArrayList;
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
import br.edu.ifrn.patterns.CursoDelegate;
import br.edu.ifrn.patterns.DiretoriaDelegate;
import br.edu.ifrn.patterns.EmpresaDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;
import br.edu.ifrn.patterns.AlunoDelegate;

@With(SessionsHelper.class)
public class OfertasEstagio extends Controller {

	//	public static void index() {
	//		formCadastro();
	//	}

	@Permissao("funcionario")
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

	@Permissao("funcionario")
	public static void cadastrar(OfertaEstagio o, long idEmpresa, long idDiretoria, long idCurso) {
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
				DiretoriaDelegate diretoriaDelegate = new DiretoriaDelegate();
				CursoDelegate cursoDelegate = new CursoDelegate();

				Empresa e = del_empresa.getEmpresa(idEmpresa);
				Diretoria d = diretoriaDelegate.getDiretoria(idDiretoria);
				Curso c = cursoDelegate.getCurso(idCurso);

				o.setEmpresa(e);
				o.setDiretoria(d);
				o.setCurso(c);

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

	@Permissao("aluno")
	public static void candidatarAluno(long idOferta ) throws Exception{
		long alunoId = Long.parseLong(session.get("usuarioAtivoID"));
		System.out.println(alunoId+"  "+idOferta);
		OfertaEstagioDelegate del_oe = new OfertaEstagioDelegate();
		del_oe.inserirCandidato(idOferta, alunoId);
		Application.ofertaEstagio();
	}

	@Permissao("aluno")
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

	@Permissao("funcionario")
	public static void getDadosEmpresa(Long id) {
		try{
			EmpresaDelegate del = new EmpresaDelegate();
			Empresa e = del.getEmpresa(id);
			StringBuilder sb = new StringBuilder();

			sb.append("<fieldset>" + "\n");
			sb.append("<legend>Confirmação dos dados da empresa escolhida:</legend>" + "\n");
			sb.append("<strong>Razão Social: </strong>" + e.getRazaoSocial() + "<br/>" + "\n");
			sb.append("<strong>Nome Fantasia: </strong>" + e.getNomeFantasia() + "<br/>" + "\n");
			sb.append("<strong>Área de Atuação: </strong>" + e.getAreaAtuacao() + "<br/>" + "\n");
			sb.append("<strong>Nome do Responsável: </strong>" + e.getNomeResponsavel() + "<br/>" + "\n");
			sb.append("</fieldset>" + "\n");

			renderText(sb.toString());
		} catch (Exception er) {
			renderText("ERRO: " + er.getLocalizedMessage());
		}
	}

	@Permissao("funcionario")
	public static void verDetalheOferta(Long id) throws Exception{
		OfertaEstagioDelegate del = new OfertaEstagioDelegate();
		OfertaEstagio oferta = del.getOfertaEstagio(id);
		render(oferta);
	}

	@Permissao("funcionario")
	public static void verOfertas(String diretoria) throws Exception{
		OfertaEstagioDelegate del = new OfertaEstagioDelegate();
		DiretoriaDelegate ddel = new DiretoriaDelegate();
		List<OfertaEstagio> lista = new ArrayList<OfertaEstagio>();
		if (diretoria!=null){
			lista = del.getTodasOfertasEstagioByDiretoria(diretoria);
		}
		List<Diretoria> diretorias = ddel.getTodasDiretorias();
		renderArgs.put("diretoriaSelec", diretoria);
		render(lista, diretorias);
	}
}