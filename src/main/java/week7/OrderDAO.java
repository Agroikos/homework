package week7;

import java.math.BigInteger;
import java.util.List;

public interface OrderDAO {
    int create (Order order);
    Order findById(BigInteger orderNumber); //the "read" operation
    int update (BigInteger orderNumber, Order order);
    int delete (BigInteger orderNumber);

    List<Order> findAll();
}

/*
    List<Singer> findAllByFirstName(String firstName);
 */
