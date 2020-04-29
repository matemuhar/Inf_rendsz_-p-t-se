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
 * Servlet implementation class ClientServlet
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    @EJB
    private ClientDAO clientDAO;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clientID = request.getParameter("id");
        String name = request.getParameter("name");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String operation = request.getParameter("operation");

        Client client = new Client(clientID, name, phonenumber, address);

        if (operation.equalsIgnoreCase("Add")) {
            clientDAO.addClient(client);
            request.setAttribute("client", client);
        } else if (operation.equalsIgnoreCase("Edit")) {
            clientDAO.editClient(client);
            Client searchedClient = clientDAO.getClient(clientID);
            request.setAttribute("client", searchedClient);
        } else if (operation.equalsIgnoreCase("Delete")) {
            clientDAO.deleteClient(clientID);
        } else if (operation.equalsIgnoreCase("Search")) {
            Client searchedClient = clientDAO.getClient(clientID);
            request.setAttribute("client", searchedClient);
        }
        request.getRequestDispatcher("clientinfo.jsp").forward(request, response);
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
