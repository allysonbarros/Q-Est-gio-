package br.edu.ifrn.negocio;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="ESTAGIO_SeqGen", sequenceName="ESTAGIO_GEN_VAL")
public class Estagio {
	Empresa empresa;
	Pessoa orientador;
	Pessoa aluno;
	
	String areaConhecimento;
	String funcao;
	String descricao;
}
