package br.edu.ifrn.negocio;




import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue((TipoPessoa.ALUNO+""))	
public class Aluno extends Pessoa {
	
	private static final long serialVersionUID = -9151016583503663685L;
	@ManyToOne
	private Curso curso;
	
	//private OfertaEstagio oferta;
	
	public Aluno(){
		
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	

}
