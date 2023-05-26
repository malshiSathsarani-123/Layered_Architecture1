package bo;

import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.getAll();
    }
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.add(dto);
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.update(dto);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.exist(id);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.generateNewID();
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException{
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.delete(id);
    }

    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.search(id);
    }
}
