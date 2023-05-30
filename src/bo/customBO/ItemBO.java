package bo.customBO;

import bo.SuperBO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

     ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;

     boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean existItem(String id) throws SQLException, ClassNotFoundException ;

     String generateNewID() throws SQLException, ClassNotFoundException ;

     boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

     ItemDTO search(String id) throws SQLException, ClassNotFoundException ;
}
