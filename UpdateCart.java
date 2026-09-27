package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        System.out.print("Enter New Quantity: ");
        int quantity = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE cart SET quantity = ? " +
                         "WHERE customer_id = ? AND product_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, customerId);
            ps.setInt(3, productId);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Cart Quantity Updated Successfully!");
            } else {
                System.out.println("Product Not Found In Cart!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
