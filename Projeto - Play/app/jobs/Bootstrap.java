package jobs;

import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.InstituicaoEnsino;
import br.edu.ifrn.patterns.InstituicaoEnsinoDelegate;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() throws Exception {
		InstituicaoEnsinoDelegate del = new InstituicaoEnsinoDelegate();
		
		if (del.getTodasOfertasInstituicaoEnsino().isEmpty()) {
			InstituicaoEnsino i = new InstituicaoEnsino();
			
			i.setCnpj("10.877.412.0001-68");
			i.setRazaoSocial("Instituto Federal De Educação, Ciência e Tecnologia Do Rio Grande Do Norte");
			i.setNomeFantasia("IFRN");
			i.setEndereco(new Endereco("Rua Dr. Nilo Bezerra Ramalho", "1692", null, "Tirol", "Natal", "RN", "59015-300"));
			
			del.cadastrarInstituicaoEnsino(i);
		}
	}
}
