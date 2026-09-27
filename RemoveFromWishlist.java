package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RemoveFromWishlist {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM wishlist WHERE customer_id = ? AND product_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setInt(2, productId);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Product Removed From Wishlist Successfully!");
            } else {
                System.out.println("Product Not Found In Wishlist!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}