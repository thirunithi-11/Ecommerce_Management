package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewOrders {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT o.order_id, c.customer_name, " +
                         "p.product_name, oi.quantity, oi.price, " +
                         "o.order_date, o.status " +
                         "FROM orders o " +
                         "JOIN customers c ON o.customer_id = c.customer_id " +
                         "JOIN order_items oi ON o.order_id = oi.order_id " +
                         "JOIN products p ON oi.product_id = p.product_id";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Order ID   : " + rs.getInt("order_id"));
                System.out.println("Customer   : " + rs.getString("customer_name"));
                System.out.println("Product    : " + rs.getString("product_name"));
                System.out.println("Quantity   : " + rs.getInt("quantity"));
                System.out.println("Price      : " + rs.getDouble("price"));
                System.out.println("Order Date : " + rs.getDate("order_date"));
                System.out.println("Status     : " + rs.getString("status"));
                System.out.println("-----------------------------");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
