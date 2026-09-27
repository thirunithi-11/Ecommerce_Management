package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OrderItems {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO order_items " +
                         "(order_id, product_id, quantity, price) " +
                         "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);

            ps.executeUpdate();

            System.out.println("Order Item Added Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}