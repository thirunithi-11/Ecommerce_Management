package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateOrderStatus {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Order ID: ");
        int orderId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter New Status: ");
        String status = sc.nextLine();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE orders SET status = ? WHERE order_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, orderId);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Order Status Updated Successfully!");
            } else {
                System.out.println("Order Not Found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}