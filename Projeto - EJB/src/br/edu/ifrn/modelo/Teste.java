package br.edu.ifrn.modelo;

import java.util.List;

import br.edu.ifrn.negocio.*;
import br.edu.ifrn.patterns.EnderecoDelegate;
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EnderecoDelegate enderecoBean;

		try {
			enderecoBean = new EnderecoDelegate();
			System.out.println(enderecoBean.toString());

			Endereco e = new Endereco();
			e.setLogradouro("Rua Santa Luzia");
			e.setNumero("101");
			e.setBairro("Quintas");
			e.setCidade("Natal");
			e.setUf("RN");
			e.setCep("59035-186");

			enderecoBean.cadastrarEndereco(e);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
