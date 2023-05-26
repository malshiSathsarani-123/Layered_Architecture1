package bo.customBO.impl;

import bo.customBO.OrderBO;
import dao.custom.OrderDAO;
import dao.custom.impl.OrderDAOImpl;
import model.OrderDTO;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = new OrderDAOImpl();

    public boolean addOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.add(dto);
    }

    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        return orderDAO.exist(orderId);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewID();
    }
}
