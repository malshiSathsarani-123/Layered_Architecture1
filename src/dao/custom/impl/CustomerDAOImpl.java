package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");

        while (rst.next()) {
            Customer customerDTO = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public boolean add(Customer dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer (id,name, address) VALUES (?,?,?)";
        return SQLUtil.execute(sql,dto.getId(),dto.getName(),dto.getAddress());
    }

    @Override
    public boolean update(Customer dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
        return SQLUtil.execute(sql,dto.getName(),dto.getAddress(),dto.getId());
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT id FROM Customer WHERE id=?";
        return SQLUtil.execute(sql,s);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Customer WHERE id=?" ;
        return SQLUtil.execute(sql,s);
    }

    @Override
    public Customer search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?",s);
        rst.next();
        return new Customer(s + "", rst.getString("name"), rst.getString("address"));
    }
}