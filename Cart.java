package com.shopping.cart;
public class Cart {
    private static Cart instance = null;
    private String[] cartItems = new String[20];
    private int[] cartPrices = new int[20];
    private int index = 0;
    private Cart() {}
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }
    public void addItem(String name, int price) {
        cartItems[index] = name;
        cartPrices[index] = price;
        index++;
        System.out.println(name + " added to cart!");
    }
    public void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < index; i++) {
            if (cartItems[i] != null && cartItems[i].equalsIgnoreCase(name)) {
                cartItems[i] = null;
                cartPrices[i] = 0;
                removed = true;
                System.out.println(name + " removed from cart!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Item not found in cart!");
        }
    }
    public void viewTotal() {
        int total = 0;
        System.out.println("\nItems in Cart:");
        for (int i = 0; i < index; i++) {
            if (cartItems[i] != null) {
                System.out.println(cartItems[i] + " - ₹" + cartPrices[i]);
                total += cartPrices[i];
            }
        }
        System.out.println("Total Price: ₹" + total);
    }
    public int getTotalAmount() {
        int total = 0;
        for (int i = 0; i < index; i++) {
            total += cartPrices[i];
        }
        return total;
    }
}
