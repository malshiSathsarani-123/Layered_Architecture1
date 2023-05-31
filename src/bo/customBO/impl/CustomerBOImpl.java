package bo.customBO.impl;

import bo.customBO.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import entity.Customer;
import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    //CustomerDAO customerDAO = new CustomerDAOImpl();

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
            ArrayList<CustomerDTO> allCustomers= new ArrayList<>();
            ArrayList<Customer> all = customerDAO.getAll();
            for (Customer c : all) {
                allCustomers.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress()));
            }
            return allCustomers;
    }
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.add(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException{
        return customerDAO.delete(id);
    }
}
