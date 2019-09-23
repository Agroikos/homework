package week7;

import java.util.List;

public class DBTool {
    public static void main(String[] args) {

        ProductDAOImpl productDAO = new ProductDAOImpl();
        //productDAO.findAll().stream().forEach(System.out::println);

          /*
            ('S10_1678','1969 Harley Davidson Ultimate Chopper','Motorcycles','1:10','Min Lin Diecast',
            'This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.',
            7933,'48.81','95.70'),

             */

        /*Product sampleProduct = new Product();
        sampleProduct.setProductCode("S72_3666");
        sampleProduct.setProductName("Indian");
        sampleProduct.setProductLine("Motorcycles");
        sampleProduct.setProductScale("1:1");
        sampleProduct.setProductVendor("Min Lin Diecast");
        sampleProduct.setProductDescription("self-explanatory");
        sampleProduct.setQuantityInStock(2);
        sampleProduct.setBuyPrice(new BigDecimal(27.99));
        sampleProduct.setMSRP(new BigDecimal(44.99));

        int rowsModified = productDAO.create(sampleProduct);
        System.out.println("Rows modified: " + rowsModified);
        productDAO.findAll().stream().forEach(System.out::println);*/

        //System.out.println("All my orders:");
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        //orderDAO.findAll().stream().forEach(o -> System.out.println(o));

        List<Order> orders = orderDAO.findAll();
        Order modifiedOrder = orders.get(3);

        modifiedOrder.setComments("Dan: this order gets a new comment");

        System.out.println("updating order #3: Rows modified: ");
        System.out.println(orderDAO.update(modifiedOrder.getOrderNumber(),modifiedOrder));
        orderDAO.findAll().stream().forEach(System.out::println);

    }

}
