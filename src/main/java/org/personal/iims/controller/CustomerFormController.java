package org.personal.iims.controller;

import org.personal.iims.dao.CustomerDao;
import org.personal.iims.dao.impl.CustomerDaoImpl;
import org.personal.iims.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CustomerFormController", urlPatterns = {"/customer-save"})
public class CustomerFormController extends HttpServlet {

    private final CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            if (id != null) {
                Customer customer = customerDao.findOne(Integer.parseInt(id));
                request.setAttribute("customer", customer);
                request.setAttribute("action", "Update");
            } else {
                request.setAttribute("action", "Save");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("customer/customer-register-update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id").trim();
        System.out.println(id);
        int result;
        try {
            Customer customer = new Customer();
            customer.setCustomerName(request.getParameter("customerName"));
            customer.setCustomerContact(request.getParameter("customerContact"));
            customer.setCustomerAddress(request.getParameter("customerAddress"));
            customer.setCustomerEmail(request.getParameter("customerEmail"));

            if (id.length() != 0) {
                customer.setId(Integer.parseInt(id));
                result = customerDao.update(customer);
            } else {
                result = customerDao.save(customer);
            }

            if (result == 1) {
                response.sendRedirect("/Book_System/customer");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
