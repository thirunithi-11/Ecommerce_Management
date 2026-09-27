package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ShoppingCart {

    public static void run(Scanner sc) {

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO cart (customer_id, product_id, quantity) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);

            ps.executeUpdate();

            System.out.println("Product Added to Cart Successfully!");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
