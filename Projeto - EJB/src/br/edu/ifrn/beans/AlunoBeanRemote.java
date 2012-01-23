package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.negocio.Aluno;

@Remote
public interface AlunoBeanRemote {
	
	public void cadastrarAluno(Aluno p);
	public void editarAluno(Aluno p);
	public void deletarAluno(Aluno p);
	public Aluno getAluno(Long id);
	public List<Aluno> getTodosAlunos();
	
	
}


