package bo.customBO;

import model.OrderDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseOrderBO {

     boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) ;
}
