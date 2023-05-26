package bo.customBO.impl;

import bo.customBO.OrderDetailBO;
import dao.custom.OrderDetailDAO;
import dao.custom.impl.OrderDetailsDAOImpl;
import model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailBOImpl implements OrderDetailBO {

    OrderDetailDAO orderDetailDAO = new OrderDetailsDAOImpl();

    public boolean add(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return orderDetailDAO.add(dto);
    }

}
