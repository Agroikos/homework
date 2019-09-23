package week7;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ProductDAOImpl implements ProductDAO {

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

        try (Connection conn = getConnection()) {

            String sql = "SELECT * FROM products WHERE productCode = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, productCode);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
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

                return product;
            } else return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

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
            String sql = "DELETE FROM products WHERE productCode = ?";
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
