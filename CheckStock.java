package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckStock {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT product_id, product_name, stock FROM products";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                    "Product ID : " + rs.getInt("product_id") +
                    " | Product : " + rs.getString("product_name") +
                    " | Stock : " + rs.getInt("stock")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}