package org.personal.iims.dao.impl;

import org.personal.iims.connectionfactory.ConnectionFactory;
import org.personal.iims.dao.BookDao;
import org.personal.iims.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    @Override
    public int save(Book book) throws ClassNotFoundException, SQLException {
        final String QUERY ="INSERT INTO book (`isbn`, `bookName`, `bookAuthor`, `stock`) VALUES (?,?,?,?)";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, book.getIsbn());
        preparedStatement.setString(2, book.getBookName());
        preparedStatement.setString(3, book.getBookAuthor());
        preparedStatement.setInt(4, book.getStock());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Book book) throws  ClassNotFoundException, SQLException {
        final String QUERY = "UPDATE book set isbn = ?, bookName = ?, bookAuthor = ?, stock = ? WHERE id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, book.getIsbn());
        preparedStatement.setString(2, book.getBookName());
        preparedStatement.setString(3, book.getBookAuthor());
        preparedStatement.setInt(4, book.getStock());
        preparedStatement.setInt(5, book.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "DELETE FROM book where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Book> findAll() throws ClassNotFoundException, SQLException {
        final List<Book> books = new ArrayList<>();
        final String QUERY = "SELECT *FROM book";
        connection = ConnectionFactory.getConnection();
        resultSet = connection.prepareStatement(QUERY).executeQuery();
        while(resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setBookName(resultSet.getString("bookName"));
            book.setBookAuthor(resultSet.getString("bookAuthor"));
            book.setStock(resultSet.getInt("stock"));
            books.add(book);
        }
        return books;
    }

    @Override
    public Book findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY ="SELECT *FROM book where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        Book book = new Book();
        while(resultSet.next()) {
            book.setId(resultSet.getInt("id"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setBookName(resultSet.getString("bookName"));
            book.setBookAuthor(resultSet.getString("bookAuthor"));
            book.setStock(resultSet.getInt("stock"));
        }
        return book;
    }
}
