package bo;

import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.getAll();
    }
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.add(dto);
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.update(dto);
    }

    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.exist(id);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.generateNewID();
    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException{
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.delete(id);
    }

    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
        ItemDAO itemDAO = new ItemDAOImpl();
        return itemDAO.search(id);
    }
}
