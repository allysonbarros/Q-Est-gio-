package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import play.mvc.Controller;
import br.edu.ifrn.negocio.Aluno;
import br.edu.ifrn.negocio.OfertaEstagio;
import br.edu.ifrn.negocio.Orientador;
import br.edu.ifrn.patterns.AlunoDelegate;
import br.edu.ifrn.patterns.EstagioDelegate;
import br.edu.ifrn.patterns.OfertaEstagioDelegate;
import br.edu.ifrn.patterns.OrientadorDelegate;

public class Estagios extends Controller{
	
	public static void confirmarEstagio(List<Long> idCandidato, Long idOferta) throws Exception{
		AlunoDelegate ad = new AlunoDelegate();
		OfertaEstagioDelegate oed = new OfertaEstagioDelegate();
		OfertaEstagio oferta = oed.getOfertaEstagio(idOferta);
		List<Orientador> orientadores = oferta.getDiretoria().getOrientadores();
		Random rand = new Random();
		List<Orientador> ordemOrientador = new ArrayList<Orientador>();
		List<Aluno> selecionados = new ArrayList<Aluno>();
		
		EstagioDelegate ed = new EstagioDelegate();
		
		for (Long idCand : idCandidato) {
			int posOrientador = rand.nextInt(orientadores.size());
			Orientador o = orientadores.get(posOrientador);
			Long idOrientador = o.getId();
			ordemOrientador.add(o);
			ed.registrarEstagio(idCand, idOrientador, idOferta);
			selecionados.add(ad.getAluno(idCand));
			
		}
		
		
		
		render(selecionados, oferta);
	}
}
