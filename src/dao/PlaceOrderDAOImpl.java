package dao;

import db.DBConnection;
import model.ItemDTO;
import model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderDAOImpl {
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        /*Transaction*/
        Connection connection = null;
        try {
            connection.setAutoCommit(false);
            OrderDAOImpl orderDAO = new OrderDAOImpl();
            boolean isSave = orderDAO.save(orderId,orderDate,customerId);
//            connection = DBConnection.getDbConnection().getConnection();
//            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
//            stm.setString(1, orderId);
//            /*if order id already exist*/
//            if (stm.executeQuery().next()) {
//
//            }
//
//            connection.setAutoCommit(false);
//            stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
//            stm.setString(1, orderId);
//            stm.setDate(2, Date.valueOf(orderDate));
//            stm.setString(3, customerId);
//
            if (!isSave) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            connection.setAutoCommit(false);
            OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
            boolean isSave1 = orderDetailDAO.save(orderId,orderDetails);

            if (!isSave1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
//            stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

            for (OrderDetailDTO detail : orderDetails) {
//                stm.setString(1, orderId);
//                stm.setString(2, detail.getItemCode());
//                stm.setBigDecimal(3, detail.getUnitPrice());
//                stm.setInt(4, detail.getQty());

//                if (stm.executeUpdate() != 1) {
//                    connection.rollback();
//                    connection.setAutoCommit(true);
//                    return false;
//                }

//                //Search & Update Item

                ItemDAOImpl itemDAO  = new ItemDAOImpl();
//                ItemDTO item = itemDAO.findItem(detail.getItemCode());
//                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                connection.setAutoCommit(false);
                boolean isUpdateQty = itemDAO.updateQty(orderDetails);

                if (!isUpdateQty) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
//                ItemDTO item = findItem(detail.getItemCode());
//                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

//                PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//                pstm.setString(1, item.getDescription());
//                pstm.setBigDecimal(2, item.getUnitPrice());
//                pstm.setInt(3, item.getQtyOnHand());
//                pstm.setString(4, item.getCode());

//                if (!(pstm.executeUpdate() > 0)) {
//                    connection.rollback();
//                    connection.setAutoCommit(true);
//                    return false;
//                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
