package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products WHERE product_name LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("Product ID : " + rs.getInt("product_id"));
                System.out.println("Product    : " + rs.getString("product_name"));
                System.out.println("Category   : " + rs.getString("category"));
                System.out.println("Price      : " + rs.getDouble("price"));
                System.out.println("Stock      : " + rs.getInt("stock"));
                System.out.println("-------------------------");
            }

            if (!found) {
                System.out.println("Product Not Found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}