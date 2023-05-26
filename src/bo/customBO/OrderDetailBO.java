package bo.customBO;

import model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailBO {

     boolean add(OrderDetailDTO dto) throws SQLException, ClassNotFoundException ;

}
