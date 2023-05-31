package bo.customBO.impl;

import bo.customBO.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

//    ItemDAO itemDAO = new ItemDAOImpl();

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allEntityData = itemDAO.getAll();
        ArrayList<ItemDTO> allDTOData= new ArrayList<>();
        for (Item i : allEntityData) {
            allDTOData.add(new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return allDTOData;
    }
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.add(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.update(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
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
}
