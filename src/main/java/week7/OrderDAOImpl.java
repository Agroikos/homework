package week7;

import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    OrderDAOImpl orderDAO = new OrderDAOImpl();

    @Override
    public int create(Order order) {
        /*
        private BigInteger orderNumber;
        private LocalDate orderDate;
        private LocalDate requiredDate;
        private LocalDate shippedDate;
        private String status;
        private String comments;
        private BigInteger customerNumber;
         */

        int rowsModified = -1;

        try (Connection conn = getConnection()) {

            String sql = "INSERT INTO orders (orderNumber,orderDate,requiredDate,shippedDate,status,comments,customerNumber) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, order.getOrderNumber().toString());
            preparedStatement.setString(2, order.getOrderDate().toString());
            preparedStatement.setString(3, order.getRequiredDate().toString());
            preparedStatement.setString(4, order.getShippedDate().toString());
            preparedStatement.setString(5, order.getStatus().toString());
            preparedStatement.setString(6, order.getComments());
            preparedStatement.setString(7, order.getCustomerNumber().toString());

            rowsModified = preparedStatement.executeUpdate();
            return rowsModified;

        } catch (SQLException e) {
            e.printStackTrace();
            return rowsModified;
        }

    }

    @Override
    public Order findById(BigInteger orderNumber) {
        return null;
    }

    @Override
    public int update(BigInteger orderNumber, Order order) {
        int rowsModified = -1;

        try (Connection conn = getConnection()) {

            String sql = "UPDATE orders " +
                    "SET orderDate = ?," +
                    "requiredDate = ?," +
                    "shippedDate = ?," +
                    "status = ?," +
                    "comments = ?," +
                    "customerNumber = ?" +
                    "WHERE orderNumber = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, order.getOrderDate().toString());
            preparedStatement.setString(2, order.getRequiredDate().toString());
            preparedStatement.setString(3, order.getShippedDate().toString());
            preparedStatement.setString(4, order.getStatus().toString());
            preparedStatement.setString(5, order.getComments());
            preparedStatement.setString(6, order.getCustomerNumber().toString());
            preparedStatement.setString(7, order.getOrderNumber().toString());

            rowsModified = preparedStatement.executeUpdate();

            preparedStatement.close();

            return rowsModified;

        } catch (SQLException e) {
            e.printStackTrace();
            return rowsModified;
        }

    }

    @Override
    public int delete(BigInteger orderNumber) {
        int rowsModified = -1;

        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM orders WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orderNumber.toString());

            rowsModified = preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return rowsModified;
        }
        return rowsModified;
    }

    @Override
    public List<Order> findAll() {

        List<Order> orders = new ArrayList<>();

        try (Connection connection = getConnection()) {

            String sql = "SELECT * FROM orders";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            //moves the cursor along the resultSet
            while (resultSet.next()) {

               /*
        private BigInteger orderNumber;
        private LocalDate orderDate;
        private LocalDate requiredDate;
        private LocalDate shippedDate;
        private String status;
        private String comments;
        private BigInteger customerNumber;
         */

                Order order = new Order();

                order.setOrderNumber(new BigInteger(resultSet.getString("orderNumber")));
                order.setOrderDate(LocalDate.parse(resultSet.getString("orderDate")));
                order.setRequiredDate(LocalDate.parse(resultSet.getString("requiredDate")));
                order.setShippedDate(LocalDate.parse(resultSet.getString("shippedDate")));
                order.setStatus(resultSet.getString("status"));
                order.setComments(resultSet.getString("comments"));
                order.setCustomerNumber(new BigInteger(resultSet.getString("customerNumber")));

                orders.add(order);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return orders;
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
