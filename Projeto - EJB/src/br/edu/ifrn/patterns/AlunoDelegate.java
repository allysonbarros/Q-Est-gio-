package br.edu.ifrn.patterns;

import java.util.List;

import br.edu.ifrn.beans.AlunoBeanRemote;
import br.edu.ifrn.negocio.Aluno;

public class AlunoDelegate {
	
	ServiceLocator locator;
	AlunoBeanRemote bean;
	
	public AlunoDelegate() throws Exception{
		locator = ServiceLocator.getInstace(); 
		bean = locator.getAlunoBean();
	}
	
	public void cadastrarAluno(Aluno p) {
		bean.cadastrarAluno(p);
	}

	public void editarAluno(Aluno p) {
		bean.editarAluno(p);
	}

	public void deletarAluno(Aluno p) {
		bean.deletarAluno(p);
	}

	public Aluno getAluno(Long id) {
		return bean.getAluno(id);
	}

	public List<Aluno> getTodasAlunos() {
		return bean.getTodosAlunos();
	}

}
