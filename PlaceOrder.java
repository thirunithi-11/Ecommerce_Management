package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PlaceOrder {

    public static void run(Scanner sc) {

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Total Amount: ");
        double totalAmount = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO orders "
                       + "(customer_id, order_date, total_amount, status) "
                       + "VALUES (?, CURDATE(), ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setDouble(2, totalAmount);
            ps.setString(3, "Placed");

            ps.executeUpdate();

            System.out.println("Order Placed Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
