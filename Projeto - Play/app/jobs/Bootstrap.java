package jobs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.pattern.LogEvent;

import com.google.gson.JsonArray;

import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.IO;
import br.edu.ifrn.negocio.Diretoria;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.InstituicaoEnsino;
import br.edu.ifrn.patterns.DiretoriaDelegate;
import br.edu.ifrn.patterns.InstituicaoEnsinoDelegate;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() throws Exception {
		InstituicaoEnsinoDelegate del = new InstituicaoEnsinoDelegate();
		DiretoriaDelegate del2 = new DiretoriaDelegate();
		
		if (del.getTodasOfertasInstituicaoEnsino().isEmpty()) {
			InstituicaoEnsino i = new InstituicaoEnsino();
			
			i.setCnpj("10.877.412.0001-68");
			i.setRazaoSocial("Instituto Federal De Educação, Ciência e Tecnologia Do Rio Grande Do Norte");
			i.setNomeFantasia("IFRN");
			i.setEndereco(new Endereco("Rua Dr. Nilo Bezerra Ramalho", "1692", null, "Tirol", "Natal", "RN", "59015-300"));
			
			if (del2.getTodasDiretoria().isEmpty()) {
				List<Diretoria> lista = new ArrayList<Diretoria>();
				List<String> readLines = IO.readLines(new File("diretorias.txt"));
				
				for (String s : readLines) {
					String d[] = s.trim().split(";");
					
					lista.add(new Diretoria(d[0], d[1], null, i));
					Logger.info("Diretoria \"" + d[0] + "\" adicionada com sucesso!");
				}
				
				i.setDiretorias(lista);
			}
			
			Logger.info("Instituição de ensino \"" + i.getRazaoSocial() + "\" cadastrada com sucesso!");
			del.cadastrarInstituicaoEnsino(i);
		}
	}
}
