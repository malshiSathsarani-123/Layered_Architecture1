package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItems = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        while (rst.next()) {
            allItems.add(new Item(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return allItems;
    }

    @Override
    public boolean add(Item dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql,dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return SQLUtil.execute(sql,dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM Item WHERE code=?";
        return SQLUtil.execute(sql,code);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Item WHERE code=?";
        return SQLUtil.execute(sql,code);
    }

    @Override
    public Item search(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Item WHERE code=?";
        return SQLUtil.execute(sql,code);
    }

    public ArrayList<Item> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> allItems = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        while (rst.next()) {
            allItems.add(new Item(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return allItems;
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Item WHERE code=?";
        return SQLUtil.execute(sql,code);
    }

    public boolean saveItem(Item dto) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql,dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    public boolean updateItem(Item dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return SQLUtil.execute(sql,dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM Item WHERE code=?";
        return SQLUtil.execute(sql,code);
    }

    public String generateNewCode() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Item WHERE code=?";
        return SQLUtil.execute(sql,code);
    }
}