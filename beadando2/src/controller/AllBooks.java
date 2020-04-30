package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.ejb.BookDAO;

/**
 * Servlet implementation class AllBooks
 */
@WebServlet(name = "AllClients", urlPatterns = {"/AllClients"})
public class AllBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private BookDAO bookDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBooks() {
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
		ArrayList<Book> list = bookDAO.getAllBook();
		request.setAttribute("list", list);
		request.getRequestDispatcher("allbooks.jsp").forward(request, response);
	}

}
