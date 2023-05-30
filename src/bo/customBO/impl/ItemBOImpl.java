package bo.customBO.impl;

import bo.customBO.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

//    ItemDAO itemDAO = new ItemDAOImpl();

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.add(dto);
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.update(dto);
    }

    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException{
        return itemDAO.delete(id);
    }

    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }
}
