package org.personal.iims.controller;

import org.personal.iims.dao.BookDao;
import org.personal.iims.dao.impl.BookDaoImpl;
import org.personal.iims.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BookController", urlPatterns = {"/register"})
public class BookController extends HttpServlet {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("book-register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        int stock = Integer.parseInt(request.getParameter("stock"));
        Book book = new Book(isbn, bookName, bookAuthor, stock);
        try {
            bookDao.save(book);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
