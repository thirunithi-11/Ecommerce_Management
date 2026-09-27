package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStock {

    public static void run(Scanner sc) {

        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();

        System.out.print("Enter New Stock: ");
        int stock = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE products SET stock = ? WHERE product_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, stock);
            ps.setInt(2, productId);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Stock Updated Successfully!");
            } else {
                System.out.println("Product Not Found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}