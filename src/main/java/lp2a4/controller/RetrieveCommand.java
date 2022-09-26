package lp2a4.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lp2a4.Logger;
import lp2a4.modelo.AlunoDAO;
import lp2a4.modelo.AlunoPOJO;

/**
 * 
 * @author diego
 *
 */
public class RetrieveCommand implements Command {
	
	private static Logger log = new Logger(Command.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String matricula = request.getParameter("matricula");
		final AlunoDAO dao = AlunoDAO.getInstance();
		final AlunoPOJO aluno = dao.retrieve(matricula);
		request.setAttribute("aluno", aluno);
		log.info("Colocando o aluno " + aluno.getMatricula() + " no request.");
		final RequestDispatcher rd = request.getRequestDispatcher("exibir_aluno.jsp");
		rd.forward(request, response); 

	}

}
