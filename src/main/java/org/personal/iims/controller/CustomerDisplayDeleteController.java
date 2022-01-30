package org.personal.iims.controller;

import org.personal.iims.dao.CustomerDao;
import org.personal.iims.dao.impl.CustomerDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CustomerDisplayDeleteController", urlPatterns = {"/customer"})
public class CustomerDisplayDeleteController extends HttpServlet {
    private final CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            if (id != null) {
                int result = customerDao.delete(Integer.parseInt(id));
                if (result == 1) {
                    request.setAttribute("customers", customerDao.findAll());
                    response.sendRedirect("/Book_System/customer");
                }
            } else {
                request.setAttribute("customers", customerDao.findAll());
                request.getRequestDispatcher("/customer.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
