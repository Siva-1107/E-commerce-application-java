package com.shopping.order;
import java.util.Random;
public class Order {
    public void makePayment(String method, int amount) {
        System.out.println("\nplease wait...");
        System.out.println("Payment Method: " + method);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Payment Successful!");
    }
    public void generateOrder() {
        Random r = new Random();
        int orderId = 100000 + r.nextInt(900000);
        System.out.println("Order Confirmed! Your Order ID is: " + orderId);
    }
}
