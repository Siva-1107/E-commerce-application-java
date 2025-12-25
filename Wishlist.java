package com.shopping.wishlist;
public class Wishlist {
    private String[] items = new String[20];
    private int index = 0;
    public void addToWishlist(String name) {
        items[index++] = name;
        System.out.println(name + " added to wishlist!");
    }
    public void showWishlist() {
        System.out.println("\nWishlist Items:");
        for (int i = 0; i < index; i++) {
            System.out.println(items[i]);
        }
    }
}
