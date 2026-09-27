 package ecommerce;

import java.util.Scanner;

public class ECommerceMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== E-COMMERCE MANAGEMENT SYSTEM =====");
            System.out.println("1. Product Catalog");
            System.out.println("2. Shopping Cart");
            System.out.println("3. Wishlist");
            System.out.println("4. Place Order");
            System.out.println("5. Order Tracking");
            System.out.println("6. Check Stock");
            System.out.println("7. Update Stock");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                ProductCatalog.main(null);
                break;

            case 2:
                ShoppingCart.run(sc);
                break;

            case 3:
                Wishlist.run(sc);
                break;

            case 4:
                PlaceOrder.run(sc);
                break;

            case 5:
                OrderTracking.run(sc);
                break;
                

            case 6:
                CheckStock.main(null);
                break;

            case 7:
                UpdateStock.run(sc);
                break;

            case 8:
                System.out.println("Thank You!");
                
                return;

            default:
                System.out.println("Invalid Choice!");
            }
        }
    }
}