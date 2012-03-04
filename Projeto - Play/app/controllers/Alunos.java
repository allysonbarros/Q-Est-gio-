package controllers;

import static play.modules.pdf.PDF.renderPDF;
import helpers.Permissao;
import helpers.SessionsHelper;

import java.util.ArrayList;
import java.util.List;

import play.mvc.Controller;
import play.mvc.With;
import br.edu.ifrn.negocio.Aluno;
import br.edu.ifrn.negocio.Diretoria;
import br.edu.ifrn.negocio.Habilidade;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.patterns.AlunoDelegate;
import br.edu.ifrn.patterns.CursoDelegate;
import br.edu.ifrn.patterns.DiretoriaDelegate;
@With(SessionsHelper.class)
public class Alunos extends Controller {

//	public static void index() {
//		render();
//	}
	
	@Permissao("aluno")
	public static void meusDados() throws Exception {
		AlunoDelegate del = new AlunoDelegate();
		long alunoId = Long.parseLong(session.get("usuarioAtivoID"));
		Aluno p = del.getAluno(alunoId);
		
		render(p);
	}
	
	@Permissao("aluno")
	public static void imprimirCurriculo(String formato) throws Exception {
		AlunoDelegate del = new AlunoDelegate();
		long alunoId = Long.parseLong(session.get("usuarioAtivoID"));
		Aluno aluno = del.getAluno(alunoId);
		
		List<Habilidade> idiomas = new ArrayList<Habilidade>();
		List<Habilidade> informatica = new ArrayList<Habilidade>();
		List<Habilidade> outrosConhecimentos = new ArrayList<Habilidade>();
		
//		for (Habilidade habilidade : aluno.getHabilidades()) {
//			switch (habilidade.getTipoHabilidade()) {
//			case 0:
//				idiomas.add(habilidade);
//				break;
//			case 1:
//				informatica.add(habilidade);
//				break;
//			case 2:
//				outrosConhecimentos.add(habilidade);
//				break;
//			default:
//				break;
//			}
//		}
		
		if (formato == null || formato.equals("")) {
			render(aluno, idiomas, informatica, outrosConhecimentos);
		} else {
			renderPDF(aluno, idiomas, informatica, outrosConhecimentos);
		}
	}
	
	@Permissao("funcionario")
	public static void formCadastro() throws Exception {
		DiretoriaDelegate diretoriaDelegate = new DiretoriaDelegate();
		List<Diretoria> diretorias = diretoriaDelegate.getTodasDiretorias();
		
		render(diretorias);
	}
	
	@Permissao("funcionario")
	public static void cadastrar(Aluno p, String confirmacaoSenha, Long idDiretoria, Long idCurso) throws Exception {
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
//		validation.required("mae",p.getNomeMae()).message("O campo Nome da Mãe deve ser preenchido.");
//		validation.required("pai",p.getNomePai()).message("O campo Nome do Pai deve ser preenchido");
		//    	validation.required(p.getNomeConjuge());
		validation.required("senha",p.getUsuario().getSenha()).message("O campo Senha deve ser preenchido");
		//validation.equals("asd ",p.getUsuario().getSenha(), confirmacaoSenha, confirmacaoSenha);

		if (validation.hasErrors()) {
			DiretoriaDelegate del2 = new DiretoriaDelegate();
			flash.error("<strong>Atenção:</strong> Você deve preencher os campos corretamente!");

			renderArgs.put("p", p);
			renderArgs.put("diretorias", del2.getTodasDiretorias());
			renderArgs.put("cursos", del2.getDiretoria(idDiretoria).getCursos());
			
			renderArgs.put("idDiretoria", idDiretoria);
			renderArgs.put("idCurso", idCurso);
			
			renderTemplate("Alunos/formCadastro.html");
		} else {			
			try {
				AlunoDelegate del = new AlunoDelegate();
				DiretoriaDelegate del2 = new DiretoriaDelegate();
				CursoDelegate del3 = new CursoDelegate();

				p.getUsuario().setLogin(p.getMatricula().toString());
				p.getUsuario().setTipoUsuario(TipoPessoa.ALUNO);
				
				p.setDiretoria(del2.getDiretoria(idDiretoria));
				p.setCurso(del3.getCurso(idCurso));
				
				del.cadastrarAluno(p);
			} catch (Exception e) {
				DiretoriaDelegate del2 = new DiretoriaDelegate();
				flash.error("<strong>Erro:</strong> " + e.getMessage());
				
				renderArgs.put("p", p);
				renderArgs.put("diretorias", del2.getTodasDiretorias());
				
				e.printStackTrace();
				
				renderTemplate("Alunos/formCadastro.html");
			}
			
			flash.success("Aluno cadastrado com sucesso!");
			formCadastro();
		}
	}
}
