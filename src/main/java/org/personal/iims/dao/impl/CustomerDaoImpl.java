package org.personal.iims.dao.impl;

import org.personal.iims.connectionfactory.ConnectionFactory;
import org.personal.iims.dao.CustomerDao;
import org.personal.iims.model.Book;
import org.personal.iims.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;


    @Override
    public int save(Customer customer) throws ClassNotFoundException, SQLException {
        final String QUERY ="INSERT INTO customer (customerName, customerContact, customerAddress, customerEmail) VALUES (?,?,?,?)";
        connection = ConnectionFactory.getConnection();
        System.out.println(customer);
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, customer.getCustomerName());
        preparedStatement.setString(2, customer.getCustomerContact());
        preparedStatement.setString(3, customer.getCustomerAddress());
        preparedStatement.setString(4, customer.getCustomerEmail());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Customer customer) throws ClassNotFoundException, SQLException {
        final String QUERY = "UPDATE customer set customerName = ?, customerContact = ?, customerAddress = ?, customerEmail = ? WHERE id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, customer.getCustomerName());
        preparedStatement.setString(2, customer.getCustomerContact());
        preparedStatement.setString(3, customer.getCustomerAddress());
        preparedStatement.setString(4, customer.getCustomerEmail());
        preparedStatement.setInt(5, customer.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        final String QUERY = "DELETE FROM customer where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Customer> findAll() throws ClassNotFoundException, SQLException {
        final List<Customer> customers = new ArrayList<>();
        final String QUERY = "SELECT *FROM customer";
        connection = ConnectionFactory.getConnection();
        resultSet = connection.prepareStatement(QUERY).executeQuery();
        while(resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setCustomerName(resultSet.getString("customerName"));
            customer.setCustomerContact(resultSet.getString("customerContact"));
            customer.setCustomerAddress(resultSet.getString("customerAddress"));
            customer.setCustomerEmail(resultSet.getString("customerEmail"));
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer findOne(int id) throws ClassNotFoundException, SQLException {
        final String QUERY ="SELECT *FROM customer where id = ?";
        connection = ConnectionFactory.getConnection();
        preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();

        Customer customer = new Customer();

        while(resultSet.next()) {
            customer.setId(resultSet.getInt("id"));
            customer.setCustomerName(resultSet.getString("customerName"));
            customer.setCustomerContact(resultSet.getString("customerContact"));
            customer.setCustomerAddress(resultSet.getString("customerAddress"));
            customer.setCustomerEmail(resultSet.getString("customerEmail"));
        }

        return customer;
    }
}
