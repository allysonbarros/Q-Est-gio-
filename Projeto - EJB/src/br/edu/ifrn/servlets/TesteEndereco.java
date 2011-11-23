package br.edu.ifrn.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifrn.beans.EnderecoBeanLocal;
import br.edu.ifrn.beans.PessoaBeanLocal;
import br.edu.ifrn.negocio.Endereco;
import br.edu.ifrn.negocio.Pessoa;
import br.edu.ifrn.negocio.Usuario;

/**
 * Servlet implementation class TesteEndereco
 */
@WebServlet("/TesteEndereco")
public class TesteEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private EnderecoBeanLocal ejb;
	
	@EJB 
	private PessoaBeanLocal ejb2;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteEndereco() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Endereco e = new Endereco();
		e.setLogradouro("Rua Santa Luzia");
		e.setNumero("101");
		e.setBairro("Quintas");
		e.setCidade("Natal");
		e.setUf("RN");
		e.setCep("59035-186");
		
		Pessoa p = new Pessoa();
		p.setNome("Allyson Barros");
		p.setEndereco(e);
		try {
			p.setUsuario(new Usuario(p, "allysonbarrosrn@gmail.com", "allysonbarros", "1234", true));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ejb2.cadastrarPessoa(p);
		//ejb.cadastrarEndereco(e);
	}

}
