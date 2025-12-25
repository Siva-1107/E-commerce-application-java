package com.shopping.catalog;
public class ProductCatalog {
    public static String[][] products = {
        {"Laptop", "98655"},
        {"Mouse", "1299"},
        {"Keyboard", "2500"},
        {"Monitor", "15999"},
        {"Headphones", "4599"}
    };
    public static void searchProduct(String name) {
        boolean found = false;
        for (int i = 0; i < products.length; i++) {
            if (products[i][0].equalsIgnoreCase(name)) {
                System.out.println("Product Found: " + products[i][0] + " - ₹" + products[i][1]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found!");
        }
    }
    public static void sortByPrice() {
        for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (Integer.parseInt(products[i][1]) > Integer.parseInt(products[j][1])) {
                    String[] temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("\nProducts Sorted by Price:");
        for (String[] p : products) {
            System.out.println(p[0] + " - ₹" + p[1]);
        }
    }
}
