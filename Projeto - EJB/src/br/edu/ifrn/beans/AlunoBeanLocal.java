package br.edu.ifrn.beans;
import java.util.List;
import javax.ejb.Local;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.Aluno;

@Local
public interface AlunoBeanLocal {
	public void cadastrarAluno(Aluno p) throws DatabaseException;
	public void editarAluno(Aluno p) throws DatabaseException;
	public void deletarAluno(Aluno p) throws DatabaseException;
	public Aluno getAluno(Long id) throws DatabaseException;
	public List<Aluno> getTodosAlunos() throws DatabaseException;
}
