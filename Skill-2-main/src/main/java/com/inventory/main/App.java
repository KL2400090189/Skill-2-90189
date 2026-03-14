package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {

            System.out.println("\n---- PRODUCT MENU ----");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Update Product Price");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Product p = new Product(name, desc, price, qty);
                    dao.saveProduct(p);
                    System.out.println("Product Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    Product product = dao.getProduct(id);

                    if (product != null) {
                        System.out.println("Name: " + product.getName());
                        System.out.println("Price: " + product.getPrice());
                        System.out.println("Quantity: " + product.getQuantity());
                    } else {
                        System.out.println("Product Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    dao.updateProduct(updateId, newPrice);
                    System.out.println("Product Updated!");
                    break;

                case 4:
                    System.out.print("Enter Product ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);
                    System.out.println("Product Deleted!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
