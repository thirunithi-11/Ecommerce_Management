package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductCatalog {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("product_id") + "  " +
                    rs.getString("product_name") + "  " +
                    rs.getString("category") + "  " +
                    rs.getDouble("price") + "  " +
                    rs.getInt("stock")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}