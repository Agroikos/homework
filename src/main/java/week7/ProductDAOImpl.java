package week7;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ProductDAOImpl implements ProductDAO {
    public static void main(String[] args) {

        ProductDAOImpl productDAO = new ProductDAOImpl();
        //productDAO.findAll().stream().forEach(System.out::println);

          /*
            ('S10_1678','1969 Harley Davidson Ultimate Chopper','Motorcycles','1:10','Min Lin Diecast',
            'This replica features working kickstand, front suspension, gear-shift lever, footbrake lever, drive chain, wheels and steering. All parts are particularly delicate due to their precise scale and require special care and attention.',
            7933,'48.81','95.70'),

             */

        Product sampleProduct = new Product();
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
        productDAO.findAll().stream().forEach(System.out::println);

    }

    @Override
    public int create(Product product) {
        int rowsModified = -1;

        try (Connection conn = getConnection()) {

            String sql = "INSERT INTO products (productCode,productName,productLine,productScale,productVendor," +
                    "productDescription,quantityInStock,buyPrice,MSRP) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductLine());
            preparedStatement.setString(4, product.getProductScale());
            preparedStatement.setString(5, product.getProductVendor());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setString(7, product.getQuantityInStock().toString());
            preparedStatement.setString(8, product.getBuyPrice().toString());
            preparedStatement.setString(9, product.getMSRP().toString());

            rowsModified = preparedStatement.executeUpdate();
            return rowsModified;

        } catch (SQLException e) {
            e.printStackTrace();
            return rowsModified;
        }
    }

    @Override
    public Product findById(String productCode) {
        return null;
    }

    @Override
    public int update(String productCode, Product product) {

        int rowsModified = -1;

        try (Connection conn = getConnection()) {

            String sql = "UPDATE products " +
                    "SET productName = ?," +
                    "productLine = ?," +
                    "productScale = ?," +
                    "productVendor = ?," +
                    "productDescription = ?," +
                    "quantityInStock = ?," +
                    "buyPrice = ?," +
                    "MSRP = ?" +
                    "WHERE productCode = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getProductLine());
            preparedStatement.setString(3, product.getProductScale());
            preparedStatement.setString(4, product.getProductVendor());
            preparedStatement.setString(5, product.getProductDescription());
            preparedStatement.setString(6, product.getQuantityInStock().toString());
            preparedStatement.setString(7, product.getBuyPrice().toString());
            preparedStatement.setString(8, product.getMSRP().toString());
            preparedStatement.setString(9, product.getProductCode());

            rowsModified = preparedStatement.executeUpdate();

            preparedStatement.close();

            return rowsModified;

        } catch (SQLException e) {
            e.printStackTrace();
            return rowsModified;
        }
    }

    @Override
    public int delete(String productCode) {
        int rowsModified = -1;

        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productCode);

            rowsModified = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return rowsModified;
        }
        return rowsModified;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM products";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            //moves the cursor along the resultSet
            while (resultSet.next()) {

                /*
                private String productCode;
                private String productName;
                private String productLine;
                private String productScale;
                private String productVendor;
                private String productDescription;
                private Integer quantityInStock;
                private BigDecimal buyPrice;
                private BigDecimal MSRP;
                */

                Product product = new Product();

                product.setProductCode(resultSet.getString("productCode"));
                product.setProductName(resultSet.getString("productName"));
                product.setProductLine(resultSet.getString("productLine"));
                product.setProductScale(resultSet.getString("productScale"));
                product.setProductVendor(resultSet.getString("productVendor"));
                product.setProductDescription(resultSet.getString("productDescription"));
                product.setQuantityInStock(resultSet.getInt("quantityInStock"));
                product.setBuyPrice(resultSet.getBigDecimal("buyPrice"));
                product.setMSRP(resultSet.getBigDecimal("MSRP"));

                products.add(product);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return products;
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=true&serverTimezone=EET",
                    "homeworkUser",
                    "homework");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
