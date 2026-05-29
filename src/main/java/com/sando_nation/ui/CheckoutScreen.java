package com.sando_nation.ui;

import com.sando_nation.model.Receipt;
import com.sando_nation.data.ReceiptFileHandler;

import com.sando_nation.model.Order;
import com.sando_nation.model.PricedItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CheckoutScreen {
    private final Scanner            scanner;
    private final DisplayHelper      display;


    public CheckoutScreen(Scanner scanner, DisplayHelper display) {
        this.scanner = scanner;
        this.display = display;
    }

    public void runCheckoutScreen(Order order) {
        if (order.getItems().isEmpty()) {
            DisplayHelper.slowPrint("  Your order is empty. Please add items before checking out.");
            return;
        }

        boolean checkingOut = true;
        while (checkingOut) {
            System.out.println(order);
            System.out.println("  y) Confirm order");
            System.out.println("  x) Remove an item");
            System.out.println("  n) Cancel order");

            switch (scanner.nextLine().toLowerCase().trim()) {
                case "y" -> { confirmOrder(order); checkingOut = false; }
                case "x" -> {
                    runRemoveAnItemScreen(order);
                    if (order.getItems().isEmpty()) {
                        DisplayHelper.slowPrint("  Order is now empty.");
                        checkingOut = false;
                    }
                }
                case "n" -> { DisplayHelper.slowPrint("  Order cancelled."); checkingOut = false; }
                default  -> DisplayHelper.slowPrint("  Invalid input.");
            }
        }
    }

    private void confirmOrder(Order order) {
        DisplayHelper.slowPrint("  Processing order...");
        Receipt receipt = new Receipt(LocalDateTime.now(), order);
        boolean success = ReceiptFileHandler.generateReceipt(receipt);
        DisplayHelper.slowPrint(success
                ? "  Order confirmed! Thank you for choosing Sando-Nation!"
                : "  Something went wrong. Please see staff.");
    }

    private void runRemoveAnItemScreen(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("  No items in your order.");
            return;
        }

        List<PricedItem> reversed = new ArrayList<>(order.getItems());
        Collections.reverse(reversed);
        display.displayOptions("Choose the item to remove:", reversed);

        int choice = display.promptMenuSelection(order.getItems().size());
        if (choice >= 0) {
            int actualIndex = order.getItems().size() - 1 - choice;
            order.removeItem(actualIndex);
            DisplayHelper.slowPrint("  Item removed.");
        }
    }
}