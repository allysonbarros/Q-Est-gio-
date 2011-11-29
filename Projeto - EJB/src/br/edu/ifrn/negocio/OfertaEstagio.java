package br.edu.ifrn.negocio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="OFERTAESTAGIO_SeqGen", sequenceName="OFERTAESTAGIO_GEN_VAL")
public class OfertaEstagio  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Empresa empresa;
	List<Pessoa> candidatos;
	String areaConhecimento;
	String funcao;
	String descricao;
}
