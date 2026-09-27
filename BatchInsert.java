package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchInsert {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO products " +
                         "(product_name, category, price, stock) " +
                         "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Keyboard");
            ps.setString(2, "Accessories");
            ps.setDouble(3, 1200);
            ps.setInt(4, 20);
            ps.addBatch();

            ps.setString(1, "Mouse");
            ps.setString(2, "Accessories");
            ps.setDouble(3, 800);
            ps.setInt(4, 30);
            ps.addBatch();

            ps.setString(1, "Tablet");
            ps.setString(2, "Electronics");
            ps.setDouble(3, 18000);
            ps.setInt(4, 10);
            ps.addBatch();

            ps.executeBatch();

            System.out.println("Batch Products Inserted Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}