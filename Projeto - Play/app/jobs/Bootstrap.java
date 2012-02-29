package jobs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.IO;
import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Curso;
import br.edu.ifrn.negocio.Diretoria;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Funcionario;
import br.edu.ifrn.negocio.InstituicaoEnsino;
import br.edu.ifrn.negocio.TipoPessoa;
import br.edu.ifrn.negocio.Usuario;
import br.edu.ifrn.patterns.CursoDelegate;
import br.edu.ifrn.patterns.DiretoriaDelegate;
import br.edu.ifrn.patterns.FuncionarioDelegate;
import br.edu.ifrn.patterns.InstituicaoEnsinoDelegate;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() throws Exception {
		try {
			InstituicaoEnsinoDelegate instituicaoDelegate = new InstituicaoEnsinoDelegate();
			DiretoriaDelegate diretoriaDelegate = new DiretoriaDelegate();
			CursoDelegate cursoDelegate = new CursoDelegate();
			FuncionarioDelegate funcionarioDelegate = new FuncionarioDelegate();
			
			if (funcionarioDelegate.getTodasFuncionarios().isEmpty()) {
				Funcionario f = new Funcionario();
				
				Usuario u = new Usuario();
				u.setLogin("admin");
				u.setSenha("admin");
				u.setAtivado(true);
				u.setPessoa(f);
				u.setTipoUsuario(TipoPessoa.FUNCIONARIO);
				
				f.setCpf("123456789010");
				f.setMatricula(123456789010L);
				f.setNome("Administrador do Sistema");
				f.setSexo("Masculino");
				f.setEndereco(new Endereco("Rua Dr. Nilo Bezerra Ramalho", "1692", null, "Tirol", "Natal", "RN", "59015-300"));
				f.setUsuario(u);
				
				funcionarioDelegate.cadastrarFuncionario(f);
			}
			
			if (instituicaoDelegate.getTodasOfertasInstituicaoEnsino().isEmpty()) {
				InstituicaoEnsino i = new InstituicaoEnsino();
				
				i.setCnpj("10.877.412.0001-68");
				i.setRazaoSocial("Instituto Federal De Educação, Ciência e Tecnologia Do Rio Grande Do Norte");
				i.setNomeFantasia("IFRN");
				i.setEndereco(new Endereco("Rua Dr. Nilo Bezerra Ramalho", "1692", null, "Tirol", "Natal", "RN", "59015-300"));
				
				if (diretoriaDelegate.getTodasDiretorias().isEmpty()) {
					List<Diretoria> lista = new ArrayList<Diretoria>();
					List<String> readLines = IO.readLines(new File("conf/diretorias.cfg"));
					
					for (String s : readLines) {
						String d[] = s.trim().split(";");
						
						lista.add(new Diretoria(d[0], d[1], null, i));
					}
					
					i.setDiretorias(lista);
				}
				
				instituicaoDelegate.cadastrarInstituicaoEnsino(i);
			}
			
			if (cursoDelegate.getTodosCursos().isEmpty()) {
				List<String> readLines2 = IO.readLines(new File("conf/cursos.cfg"));
				
				for (String st : readLines2) {
					String d[] = st.trim().split(";");
					Diretoria dir = diretoriaDelegate.getDiretoriaBySigla(d[1].toString());
					
					cursoDelegate.cadastrarCurso(new Curso(d[0], dir));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getLocalizedMessage());
		}
	}
}
