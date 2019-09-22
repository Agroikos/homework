package week7;

import java.util.List;

public interface ProductDAO {
    int create (Product product);
    Product findById(String productCode); //the "read" operation
    int update (String productCode, Product product);
    int delete (String productCode);

    List<Product> findAll();

}

/*
    List<Singer> findAllByFirstName(String firstName);
    */