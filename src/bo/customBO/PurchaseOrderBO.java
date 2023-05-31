package bo.customBO;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PurchaseOrderBO extends SuperBO {

      CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;

      ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

      boolean existItem(String code) throws SQLException, ClassNotFoundException ;

      boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

      String generateOrderID() throws SQLException, ClassNotFoundException ;

      ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException ;

      ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

      boolean purchaseOrder(OrderDTO dto)throws SQLException, ClassNotFoundException;
}
