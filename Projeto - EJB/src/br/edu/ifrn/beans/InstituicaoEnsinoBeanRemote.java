package br.edu.ifrn.beans;
import java.util.List;

import javax.ejb.Remote;

import br.edu.ifrn.exceptions.DatabaseException;
import br.edu.ifrn.negocio.InstituicaoEnsino;

@Remote
public interface InstituicaoEnsinoBeanRemote {
	public void cadastrarInstituicaoEnsino(InstituicaoEnsino p) throws DatabaseException;
	public void editarInstituicaoEnsino(InstituicaoEnsino p) throws DatabaseException;
	public void deletarInstituicaoEnsino(InstituicaoEnsino p) throws DatabaseException;
	public InstituicaoEnsino getInstituicaoEnsino(Long id) throws DatabaseException;
	public List<InstituicaoEnsino> getTodasInstituicoesEnsino() throws DatabaseException;
	
}
