package org.personal.iims.controller;


import org.personal.iims.dao.BookDao;
import org.personal.iims.dao.impl.BookDaoImpl;
import org.personal.iims.model.Book;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BookFormController", urlPatterns = {"/book-save"})
public class BookFormController extends HttpServlet {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            if (id != null) {
                Book book = bookDao.findOne(Integer.parseInt(id));
                request.setAttribute("book", book);
                request.setAttribute("action", "Update");
            } else {
                request.setAttribute("action", "Save");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("book/book-register-update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id").trim();
        System.out.println(id);
        int result;
        try {
            Book book = new Book();
            book.setIsbn(request.getParameter("isbn"));
            book.setBookName(request.getParameter("bookName"));
            book.setBookAuthor(request.getParameter("bookAuthor"));

            if (id.length() != 0) {
                book.setId(Integer.parseInt(id));
                result = bookDao.update(book);
            } else {
                result = bookDao.save(book);
            }

            if (result == 1) {
                response.sendRedirect("/Book_System/book");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

