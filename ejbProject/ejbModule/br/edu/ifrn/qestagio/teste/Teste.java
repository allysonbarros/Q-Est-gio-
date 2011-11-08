package br.edu.ifrn.qestagio.teste;

import br.edu.ifrn.qestagio.modelo.Endereco;


public class Teste {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServiceLocator locator = ServiceLocator.getInstace();
		br.edu.ifrn.qestagio.bean.EnderecoBeanRemote endereco = locator.getEnderecoBean();
		
		Endereco end = new Endereco();
		end.bairro="a";
		end.cep="3";
		end.cidade="q";
		end.complemento="r";
		end.logradouro="t";
		end.numero="123";
		
		endereco.cadastrarEndereco(end);
		
		
	}

}
