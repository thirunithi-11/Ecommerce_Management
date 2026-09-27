package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT c.customer_name, p.product_name, " +
                         "p.price, ca.quantity " +
                         "FROM cart ca " +
                         "JOIN customers c ON ca.customer_id = c.customer_id " +
                         "JOIN products p ON ca.product_id = p.product_id " +
                         "WHERE ca.customer_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("Customer  : " + rs.getString("customer_name"));
                System.out.println("Product   : " + rs.getString("product_name"));
                System.out.println("Price     : " + rs.getDouble("price"));
                System.out.println("Quantity  : " + rs.getInt("quantity"));
                System.out.println("-------------------------");
            }

            if (!found) {
                System.out.println("Cart is Empty!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}