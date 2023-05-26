package bo.customBO;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {

     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

     boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

     boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

     String generateNewID() throws SQLException, ClassNotFoundException ;

     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     CustomerDTO search(String id) throws SQLException, ClassNotFoundException ;

}