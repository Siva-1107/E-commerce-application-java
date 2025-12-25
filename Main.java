package com.shopping.main;
import java.util.Scanner;
import com.shopping.catalog.ProductCatalog;
import com.shopping.cart.Cart;
import com.shopping.wishlist.Wishlist;
import com.shopping.order.Order;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = Cart.getInstance();
        Wishlist wishlist = new Wishlist();
        Order order = new Order();
        int choice;
        do {
            System.out.println("\n==== ONLINE SHOPPING MENU ====");
            System.out.println("1. view list of products");
            System.out.println("2. search for a particular product");
            System.out.println("3. sort products based on price (low to high)");
            System.out.println("4. add product to cart (one product at a time)");
            System.out.println("5. remove item from cart");
            System.out.println("6. view total price of items in cart");
            System.out.println("7. add item to wishlist (one product at a time)");
            System.out.println("8. view the wishlist");
            System.out.println("9. pay and place order");
            System.out.println("0. exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nProducts Available:");
                    for (String[] p : ProductCatalog.products) {
                        System.out.println(p[0] + " - ₹" + p[1]);
                    }
                    break;
                case 2:
                    System.out.print("Enter product name to search: ");
                    ProductCatalog.searchProduct(sc.nextLine());
                    break;
                case 3:
                    ProductCatalog.sortByPrice();
                    break;
                case 4:
                    System.out.print("Enter product name to add to cart: ");
                    String name = sc.nextLine();
                    boolean found = false;
                    for (String[] p : ProductCatalog.products) {
                        if (p[0].equalsIgnoreCase(name)) {
                            cart.addItem(name, Integer.parseInt(p[1]));
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Product not found!");
                    break;
                case 5:
                    System.out.print("Enter product name to remove: ");
                    cart.removeItem(sc.nextLine());
                    break;
                case 6:
                    cart.viewTotal();
                    break;
                case 7:
                    System.out.print("Enter product name to wishlist: ");
                    wishlist.addToWishlist(sc.nextLine());
                    break;
                case 8:
                    wishlist.showWishlist();
                    break;
                case 9:
                    int amount = cart.getTotalAmount();
                    System.out.println("Choose Payment Method:\n1. UPI\n2. Card\n3. Cash on Delievery");
                    int m = sc.nextInt();
                    sc.nextLine();
                    String method = m == 1 ? "UPI" : m == 2 ? "Card" : "Cash on Delivery";
                    order.makePayment(method, amount);
                    order.generateOrder();
                    break;
                case 0:
                    System.out.println("Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
        sc.close();
    }
}
