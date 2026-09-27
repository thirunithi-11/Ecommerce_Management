package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OrderTransaction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        System.out.print("Enter Total Amount: ");
        double totalAmount = sc.nextDouble();

        Connection con = null;

        try {
            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String sql = "INSERT INTO orders " +
                         "(customer_id, order_date, total_amount, status) " +
                         "VALUES (?, CURDATE(), ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, customerId);
            ps.setDouble(2, totalAmount);
            ps.setString(3, "Placed");

            ps.executeUpdate();

            con.commit();

            System.out.println("Order Transaction Completed Successfully!");

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Transaction Failed!");
            e.printStackTrace();

        } finally {

            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
