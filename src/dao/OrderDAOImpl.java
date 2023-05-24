package dao;

import model.OrderDTO;

import java.sql.*;

public class OrderDAOImpl implements OrderDAO{

    @Override
    public String generateOID() throws SQLException, ClassNotFoundException {
        String sql = "SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1";
        return SQLUtil.execute(sql);
    }

    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT oid FROM `Orders` WHERE oid=?";
        return SQLUtil.execute(sql,orderId);
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)";
        return SQLUtil.execute(sql,dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
    }
}
