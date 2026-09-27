 package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Wishlist {

    public static void run(Scanner sc) {

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO wishlist (customer_id, product_id, added_date) "
                       + "VALUES (?, ?, CURDATE())";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setInt(2, productId);

            ps.executeUpdate();

            System.out.println("Product Added to Wishlist Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}