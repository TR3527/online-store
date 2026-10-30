package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> inventory = loadInventory("products.csv");
        ArrayList<Product> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String choice = "";
        while (!choice.equals("3")) {
            System.out.println();
            System.out.println("=== Welcome to the Online Store ===");
            System.out.println("1) Display Products");
            System.out.println("2) Display Cart");
            System.out.println("3) Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    displayProducts(inventory, cart, scanner);
                    break;
                case "2":
                    displayCart(cart, scanner);
                    break;
                case "3":
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Please enter 1, 2 or 3.");
            }
        }
    }

    public static ArrayList<Product> loadInventory(String fileName) {
        ArrayList<Product> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine(); // skip the header line
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String sku = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String department = parts[3];
                inventory.add(new Product(sku, name, price, department));
            }
        }
        catch (IOException e) {
            System.out.println("Could not load " + fileName + ": " + e.getMessage());
        }
        return inventory;
    }

    public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        System.out.println();
        System.out.println("=== Products ===");
        for (Product product : inventory) {
            System.out.println(product);
        }
        // TODO: let the customer search or filter the list
        System.out.print(("Filter by department: 1-Audio Video, 2-Computers, 3-Games, 4-Electronics: "));
        String userFilter = scanner.nextLine().trim();

        //String filteredProduct;

        if(userFilter.equals("1")){

            for (Product filteredProduct: inventory){

                if(filteredProduct.getDepartment().equalsIgnoreCase("Audio Video")){

                    System.out.println(filteredProduct);

                }

            }
        }else if(userFilter.equals("2")){


            for (Product filteredProduct2: inventory){

                if(filteredProduct2.getDepartment().equalsIgnoreCase("Computers")){

                    System.out.println(filteredProduct2);

                }

            }


        }else if(userFilter.equals("3")){

            for (Product filteredProduct3: inventory){

                if(filteredProduct3.getDepartment().equalsIgnoreCase("Games")){

                    System.out.println(filteredProduct3);

                }

            }


        }else if(userFilter.equals("4")){

            for (Product filteredProduct4: inventory){

                if(filteredProduct4.getDepartment().equalsIgnoreCase("Electronics")){

                    System.out.println(filteredProduct4);

                }

            }

        }else{
            System.out.println("Invalid department choice!");
        }

        // TODO: let the customer add a product to the cart (by SKU)



        // TODO: let the customer go back to the home screen
    }

    public static void displayCart(ArrayList<Product> cart, Scanner scanner) {
        System.out.println();
        System.out.println("=== Your Cart ===");
        // TODO: show every product in the cart and the total amount
        // TODO: let the customer check out, remove a product, or go back
    }
}