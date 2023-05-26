package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.OrderDAO;
import model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(OrderDTO dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)";
        return SQLUtil.execute(sql,dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
    }

    @Override
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT oid FROM `Orders` WHERE oid=?";
        return SQLUtil.execute(sql,orderId);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        String sql = "SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1";
        return SQLUtil.execute(sql);
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
