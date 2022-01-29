package org.personal.iims.controller;

import org.personal.iims.dao.BookDao;
import org.personal.iims.dao.impl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BookDisplayDeleteController", urlPatterns = {"/book"})
public class BookDisplayDeleteController extends HttpServlet {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //delete code
            String id = request.getParameter("id");
            try{
                if (id != null) {
                    int result = bookDao.delete(Integer.parseInt(id));
                    if (result == 1) {
                        request.setAttribute("books", bookDao.findAll());
                        response.sendRedirect("Book_System/book");
                    }
                } else {
                    request.setAttribute("books", bookDao.findAll());
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
    }
}
