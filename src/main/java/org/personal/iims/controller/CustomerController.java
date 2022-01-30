package org.personal.iims.controller;

import org.personal.iims.dao.CustomerDao;
import org.personal.iims.dao.impl.CustomerDaoImpl;
import org.personal.iims.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CustomerController", urlPatterns = {"/register-customer"})
public class CustomerController extends HttpServlet {

    private final CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer-register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String customerName = request.getParameter("customerName");
        String customerContact = request.getParameter("customerContact");
        String customerAddress = request.getParameter("customerAddress");
        String customerEmail = request.getParameter("customerEmail");

        Customer customer = new Customer(customerName, customerContact, customerAddress, customerEmail);

        try {
            customerDao.save(customer);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}