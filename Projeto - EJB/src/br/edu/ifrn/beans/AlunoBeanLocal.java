package br.edu.ifrn.beans;
import java.util.List;
import javax.ejb.Local;
import br.edu.ifrn.negocio.Aluno;

@Local
public interface AlunoBeanLocal {
	public void cadastrarAluno(Aluno p);
	public void editarAluno(Aluno p);
	public void deletarAluno(Aluno p);
	public Aluno getAluno(Long id);
	public List<Aluno> getTodosAlunos();
}
