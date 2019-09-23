package week7;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductDAOImplTest extends TestCase {

    @Test
    public void testInsertElement() {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        Product sampleProduct = new Product();
        sampleProduct.setProductCode("S72_3667");
        sampleProduct.setProductName("Indian by DAN");
        sampleProduct.setProductLine("Motorcycles");
        sampleProduct.setProductScale("1:76");
        sampleProduct.setProductVendor("Min Lin Diecast");
        sampleProduct.setProductDescription("BY DAN: self-explanatory");
        sampleProduct.setQuantityInStock(2);
        sampleProduct.setBuyPrice(BigDecimal.valueOf(666.666));
        sampleProduct.setMSRP(BigDecimal.valueOf(666.666));

        int rowsModified = productDAO.create(sampleProduct);
        assertEquals(1, rowsModified);
    }

    @Test
    public void testUpdateElement() {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        Product sampleProduct = new Product();
        sampleProduct.setProductCode("S72_3667");
        sampleProduct.setProductName("Indian by DAN — MODIFYYYYYY");
        sampleProduct.setProductLine("Motorcycles");
        sampleProduct.setProductScale("1:666");
        sampleProduct.setProductVendor("Min Lin Diecast");
        sampleProduct.setProductDescription("BY DAN: MODIFY : self-explanatory");
        sampleProduct.setQuantityInStock(2);
        sampleProduct.setBuyPrice(BigDecimal.valueOf(666.666));
        sampleProduct.setMSRP(BigDecimal.valueOf(666.666));

        int rowsModified = productDAO.update(sampleProduct.getProductCode(), sampleProduct);
        assertEquals(1, rowsModified);
    }

    @Test
    public void testReadElement() {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        Product sampleProduct = new Product();
        sampleProduct.setProductCode("S72_3667");
        sampleProduct.setProductName("Indian by DAN — MODIFYYYYYY");
        sampleProduct.setProductLine("Motorcycles");
        sampleProduct.setProductScale("1:666");
        sampleProduct.setProductVendor("Min Lin Diecast");
        sampleProduct.setProductDescription("BY DAN: MODIFY : self-explanatory");
        sampleProduct.setQuantityInStock(2);
        sampleProduct.setBuyPrice(BigDecimal.valueOf(666.666));
        sampleProduct.setMSRP(BigDecimal.valueOf(666.666));

        System.out.println("My sample product:");
        System.out.println(sampleProduct);

        Product returnedProduct = productDAO.findById("S72_3667");

        assertEquals(sampleProduct.getProductCode(), returnedProduct.getProductCode());
    }

    @Test
    public void testDeleteElement() {
        ProductDAOImpl productDAO = new ProductDAOImpl();

        Product sampleProduct = new Product();
        sampleProduct.setProductCode("S72_3667");
        sampleProduct.setProductName("Indian by DAN — MODIFYYYYYY");
        sampleProduct.setProductLine("Motorcycles");
        sampleProduct.setProductScale("1:666");
        sampleProduct.setProductVendor("Min Lin Diecast");
        sampleProduct.setProductDescription("BY DAN: MODIFY : self-explanatory");
        sampleProduct.setQuantityInStock(2);
        sampleProduct.setBuyPrice(new BigDecimal(666.666));
        sampleProduct.setMSRP(new BigDecimal(666.666));

        int rowsModified = productDAO.delete(sampleProduct.getProductCode());
        assertEquals(1, rowsModified);
    }

}
