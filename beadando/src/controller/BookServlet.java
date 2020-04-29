package controller;

import java.awt.print.Book;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ejb.BookDAO;


/**
 * Servlet implementation class BookServlet
 */
@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

    @EJB
    private BookDAO bookDAO;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookID = request.getParameter("id");
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String status = request.getParameter("status");
        String operation = request.getParameter("operation");

        Book book = new Book();

        if (operation.equalsIgnoreCase("Add")) {
            bookDAO.addBook(book);
            request.setAttribute("book", book);
        } else if (operation.equalsIgnoreCase("Edit")) {
            bookDAO.editBook(book);
            Book searchedBook = bookDAO.getBook(bookID);
            request.setAttribute("book", searchedBook);
        } else if (operation.equalsIgnoreCase("Delete")) {
            bookDAO.deleteBook(bookID);
        } else if (operation.equalsIgnoreCase("Search")) {
            Book searchedBook = bookDAO.getBook(bookID);
            request.setAttribute("book", searchedBook);
        }
        request.getRequestDispatcher("bookinfo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
