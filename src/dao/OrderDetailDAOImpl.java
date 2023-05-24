package dao;

import db.DBConnection;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl {
    public boolean save(String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {

        for (OrderDetailDTO dto : orderDetails){
            if (!save1(orderId,dto)){
                return false;
            }
        }
        return true;
    }

    private boolean save1(String orderId, OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

            stm.setString(1, orderId);
            stm.setString(2, dto.getItemCode());
            stm.setBigDecimal(3, dto.getUnitPrice());
            stm.setInt(4, dto.getQty());

        return stm.executeUpdate() > 0;
    }
}
