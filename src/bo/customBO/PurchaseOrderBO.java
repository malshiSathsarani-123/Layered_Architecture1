package bo.customBO;

import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO {

      CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;


      ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

      boolean existItem(String code) throws SQLException, ClassNotFoundException ;

      boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

      String generateOrderID() throws SQLException, ClassNotFoundException ;

      ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException ;

      ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

     boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) ;
}
