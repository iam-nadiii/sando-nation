package com.sando_nation.ui;

import com.sando_nation.model.Menu;
import com.sando_nation.model.Order;
import com.sando_nation.model.PricedItem;

import java.util.Scanner;

import static com.sando_nation.ui.UserInterface.generateOrderNumber;

public class OrderScreen {
    private final Scanner         scanner;
    private final Menu menu;
    private final DisplayHelper   display;
    private final OrderBuilder builder;
    private final CheckoutScreen  checkoutScreen;

    public OrderScreen(Scanner scanner, Menu menu) {
        this.scanner        = scanner;
        this.menu           = menu;
        this.display        = new DisplayHelper(scanner);
        this.builder        = new OrderBuilder(scanner, menu, display);
        this.checkoutScreen = new CheckoutScreen(scanner, display);
    }


    public void runOrderScreen() {
        Order   order   = new Order(generateOrderNumber());
        boolean inOrder = true;

        while (inOrder) {
            System.out.print("""
                \n============================
                  Order Screen
                ============================
                  1) Add Sandwich
                  2) Add Drink
                  3) Add Chips
                  4) Add Signature Sandwich
                  5) Checkout
                  0) Cancel Order
                Enter command: \s""");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addItem(order, builder.buildSandwich(),             "Sandwich");
                case "2" -> addItem(order, builder.buildDrink(),                "Drink");
                case "3" -> addItem(order, builder.buildChips(),                "Chips");
                case "4" -> addItem(order, builder.buildSignatureSandwich(),   "Signature sandwich");
                case "5" -> { checkoutScreen.runCheckoutScreen(order); inOrder = false; }
                case "0" -> { DisplayHelper.slowPrint("  Order cancelled."); inOrder = false; }
                default  -> System.out.println("  Invalid input.");
            }
        }
    }

    private void addItem(Order order, PricedItem item, String itemType) {
        order.addItem(item);
        DisplayHelper.slowPrint("\n  " + itemType + " added!");
        System.out.println(item);
    }
}