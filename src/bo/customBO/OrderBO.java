package bo.customBO;

import model.OrderDTO;

import java.sql.SQLException;

public interface OrderBO {

     boolean addOrder(OrderDTO dto) throws SQLException, ClassNotFoundException ;

     boolean existOrder(String orderId) throws SQLException, ClassNotFoundException ;

     String generateNewID() throws SQLException, ClassNotFoundException ;
}
