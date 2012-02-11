package br.edu.ifrn.negocio;




import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue((TipoPessoa.ALUNO+""))	
public class Aluno extends Pessoa {
	
	private static final long serialVersionUID = -9151016583503663685L;
	private String teste;
	
	
	//private OfertaEstagio oferta;
	
	public Aluno(){
		
	}

	

}
