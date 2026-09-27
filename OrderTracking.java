package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class OrderTracking {

    public static void run(Scanner sc) {

        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT o.order_id, c.customer_name, "
                       + "o.order_date, o.total_amount, o.status "
                       + "FROM orders o "
                       + "JOIN customers c ON o.customer_id = c.customer_id "
                       + "WHERE o.order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println();
                System.out.println("Order ID     : " + rs.getInt("order_id"));
                System.out.println("Customer     : " + rs.getString("customer_name"));
                System.out.println("Order Date   : " + rs.getDate("order_date"));
                System.out.println("Total Amount : " + rs.getDouble("total_amount"));
                System.out.println("Status       : " + rs.getString("status"));

            } else {

                System.out.println("Order Not Found!");

            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
