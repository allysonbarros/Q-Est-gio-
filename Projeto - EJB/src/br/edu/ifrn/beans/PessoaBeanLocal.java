package br.edu.ifrn.beans;
import java.util.List;
import javax.ejb.Local;
import br.edu.ifrn.negocio.Pessoa;

@Local
public interface PessoaBeanLocal {
	public void cadastrarPessoa(Pessoa p);
	public void editarPessoa(Pessoa p);
	public void deletarPessoa(Pessoa p);
	public Pessoa getPessoa(Long id);
	public List<Pessoa> getTodasPessoas();
}
