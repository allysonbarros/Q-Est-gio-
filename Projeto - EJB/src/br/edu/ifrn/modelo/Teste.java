package br.edu.ifrn.modelo;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import br.edu.ifrn.negocio.*;
public class Teste {



	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();

		//		Pessoa p = new Pessoa();
		//		p.setNome("Sedir");
		//		p.setMatricula(200920404257L);
		//		dao.save(p);
		//		
		//		p = new Pessoa();
		//		p.setNome("Lucena");
		//		p.setMatricula(1234L);
		//		dao.save(p);
		//		
		//		Empresa e = new Empresa();
		//		e.setRazaoSocial("Empresa SA");
		//		e.setNomeFantasia("Cece Alimentos Felizes");
		//		e.setCnpj(2423423423423L);
		//		e.setEmail("fulano@de.tal");
		//		e.setNumeroFuncionarios(20);
		//		e.setNomeResponsavel("Allyson Barros");
		//		dao.save(e);
		//		
		List<Pessoa> lista = dao.findAll(Pessoa.class);

//		for(Pessoa pessoa: lista){
//			System.out.println(pessoa.getNome() + pessoa.getMatricula());
//			if (pessoa.getNome().equals("Sedir")){
//				pessoa.setUsuario(new Usuario(pessoa, "philippi.sedir@gmail.com", pessoa.getMatricula()+"", "123", true, TipoPessoa.ALUNO));
//				dao.update(pessoa);
//			}
//			if (pessoa.getNome().equals("Lucena")){
//				pessoa.getUsuario().setTipoUsuario(TipoPessoa.ORIENTADOR);
//				dao.update(pessoa);
//			}
//		}

		List<Empresa> lista1 = dao.findAll(Empresa.class);

		for(Empresa pessoa: lista1){
			System.out.println(pessoa.getNomeFantasia() + pessoa.getNomeResponsavel());
		}

		OfertaEstagioDAO ofdao = new OfertaEstagioDAO();
		OfertaEstagio oe = ofdao.findById(50l);
		for (Pessoa p : oe.getCandidatos()) {
			System.out.println(p.getNome());
		}
		dao.update(oe);
		
	}
}
