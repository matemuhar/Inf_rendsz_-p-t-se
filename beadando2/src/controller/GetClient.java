package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.ejb.ClientDAO;

/**
 * Servlet implementation class GetClients
 */
@WebServlet("/GetClients")
public class GetClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB private ClientDAO clientDAO;
    	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Client client = clientDAO.getClient(id);
		request.setAttribute("client", client);
		request.getRequestDispatcher("clientinfo.jsp").forward(request, response);
	}

}
