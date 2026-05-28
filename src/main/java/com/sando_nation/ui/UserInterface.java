package com.sando_nation.ui;

import com.sando_nation.data.Receipt;
import com.sando_nation.data.ReceiptFileHandler;
import com.sando_nation.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final Menu    menu    = new Menu();
    private static final int DELAY = 800;

    public void runHomeScreen() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("""
                \n============================
                  Welcome to Sando-Nation!!
                ============================
                  1) New Order
                  0) Exit Application
                Enter command: \s""");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> runOrderScreen();
                case "0" -> isRunning = false;
                default  -> System.out.println("  Invalid input.");
            }
        }
        slowPrint("  Goodbye!");
    }

    public void runOrderScreen() {
        Order   order     = new Order((int)(Math.random() * 9000) + 1000);
        boolean inOrder   = true;

        while (inOrder) {
            System.out.print("""
                \n============================
                  Order Screen
                ============================
                  1) Add Sandwich
                  2) Add Drinks
                  3) Add Chips
                  4) Add Signature Sandwich
                  5) Checkout
                  0) Cancel Order
                Enter command: \s""");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    Sandwich sandwich = buildSandwich();
                    order.addItem(sandwich);
                    System.out.println("\n  Sandwich added!");
                    slowPrint(sandwich.toString());
                }
                case "2" ->{
                    Drink drink = buildDrink();
                    order.addItem(drink);
                    System.out.println("\n  Drink added!");
                    slowPrint(drink.toString());
                }
                case "3" ->{
                    Chips chips = buildChips();
                    order.addItem(chips);
                    System.out.println("\n Chips added!");
                    slowPrint(chips.toString());
                }
                case "4" -> {
                    SignatureSandwich signature = selectSignatureSandwich();
                    order.addItem(signature);
                    System.out.println("\n  Signature sandwich added!");
                    slowPrint(signature.toString());
                }
                case "5" -> {
                    checkout(order);
                    inOrder = false;
                }

                case "0" -> {
                    slowPrint("  Order cancelled.");
                    inOrder = false;
                }
                default -> System.out.println("  Invalid input.");
            }
        }
    }

    private SignatureSandwich selectSignatureSandwich() {
        displayOptions("Select a signature sandwich:", menu.getSignatureSandwiches());
        SignatureSandwich selected = menu.getSignatureSandwiches()
                .get(promptMenuSelection(menu.getSignatureSandwiches().size()));

        // customer picks size
        displayOptions("Select a size:", menu.getSizes());
        SandwichSize size = menu.getSizes()
                .get(promptMenuSelection(menu.getSizes().size()));

        // make a copy with the chosen size
        SignatureSandwich copy = new SignatureSandwich(
                selected.getSignatureName(),
                selected.getBread(),
                selected.getMeat(),
                selected.getCheese(),
                selected.isToasted()
        );
        copy.setSandwichSize(size); // ← size applied here, propagates to meat and cheese
        copy.initializeToppings(new ArrayList<>(selected.getRegularToppings()));
        copy.initializeSauces(new ArrayList<>(selected.getSauces()));

        System.out.println(copy);

        System.out.print("  Would you like to customize it? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            runCustomizeSignatureSandwichScreen(copy);
        }

        return copy;
    }

    private void runCustomizeSignatureSandwichScreen(SignatureSandwich sandwich) {
        boolean customizing = true;
        while (customizing) {
            System.out.print("""
            \n  Customize your sandwich:
              1) Remove a topping
              2) Add a topping
              3) Remove a sauce
              4) Add a sauce
              0) Done
            Enter command: \s""");

            switch (scanner.nextLine().trim()) {
                case "1" -> runRemoveToppingScreen(sandwich);
                case "2" -> runAddToppingScreen(sandwich);
                case "3" -> runRemoveSauceScreen(sandwich);
                case "4" -> runAddSauceScreen(sandwich);
                case "0" -> customizing = false;
                default  -> System.out.println("  Invalid input.");
            }

            if (customizing) System.out.println(sandwich);
        }
    }

    private Chips buildChips() {
        displayOptions("Select a brand of chips:", menu.getChips());
        Chips selected = menu.getChips().get(promptMenuSelection(menu.getChips().size()));
        return selected;
    }

    private Drink buildDrink() {

        // pick the drink flavor
        displayOptions("Select a drink:", menu.getDrinks());
        Drink selected = menu.getDrinks().get(promptMenuSelection(menu.getDrinks().size()));

        // pick the size
        System.out.println("\n  Select a size:");
        System.out.println("  ─────────────────────");
        System.out.println("  1. Small");
        System.out.println("  2. Medium");
        System.out.println("  3. Large");
        int sizeChoice = promptMenuSelection(3);
        switch (sizeChoice) {
            case 0 -> selected.setSize("small");
            case 1 -> selected.setSize("medium");
            case 2 -> selected.setSize("large");
        }

        return selected;
    }

    private Sandwich buildSandwich() {
        Sandwich sandwich = new Sandwich();

        // size
        displayOptions("Select a size:", menu.getSizes());
        SandwichSize size = menu.getSizes().get(promptMenuSelection(menu.getSizes().size()));
        sandwich.setSandwichSize(size);

        // bread
        displayOptions("Select your bread:", menu.getBreads());
        Bread bread = menu.getBreads().get(promptMenuSelection(menu.getBreads().size()));
        sandwich.setBread(bread);

        // meat
        displayOptions("Select your meat:", menu.getMeats());
        Meat meat = menu.getMeats().get(promptMenuSelection(menu.getMeats().size()));
        meat.setWantsExtra(askWantsExtra(meat.getName()));
        sandwich.setMeat(meat);

        // cheese
        displayOptions("Select your cheese:", menu.getCheeses());
        Cheese cheese = menu.getCheeses().get(promptMenuSelection(menu.getCheeses().size()));
        cheese.setWantsExtra(askWantsExtra(cheese.getName()));
        sandwich.setCheese(cheese);

        // initialize sandwich with all toppings first
        sandwich.initializeToppings(menu.getToppings());

        runRemoveToppingScreen(sandwich);

        // initialize sandwich with all sauces first
        sandwich.initializeSauces(menu.getSauces());

        runRemoveSauceScreen(sandwich);

        // toasted
        System.out.print("  Would you like it toasted? (y/n): ");
        sandwich.setToasted(scanner.nextLine().trim().equalsIgnoreCase("y"));

        return sandwich;
    }

    private void runRemoveToppingScreen(Sandwich sandwich) {
        while (true) {
            displayOptions("Select a topping to remove (0 when done):", sandwich.getRegularToppings());
            System.out.println("  0. Done");
            int choice = promptMenuSelection(sandwich.getRegularToppings().size());
            if (choice == -1) break;
            RegularTopping topping = sandwich.getRegularToppings().get(choice);
            sandwich.removeTopping(topping);
            slowPrint("  Removed: " + topping.getName());
        }
    }

    private void runRemoveSauceScreen(Sandwich sandwich) {
        while (true) {
            displayOptions("Select a sauce to remove (0 when done):", sandwich.getSauces());
            System.out.println("  0. Done");
            int choice = promptMenuSelection(sandwich.getSauces().size());
            if (choice == -1) break;
            Sauce sauce = sandwich.getSauces().get(choice);
            sandwich.removeSauce(sauce);
            slowPrint("  Removed: " + sauce.getName());
        }
    }

    private void runAddToppingScreen(Sandwich sandwich) {
        // only show toppings not already on the sandwich
        List<RegularTopping> available = menu.getToppings().stream()
                .filter(t -> !sandwich.getRegularToppings().contains(t))
                .collect(Collectors.toList());

        if (available.isEmpty()) {
            System.out.println("  All toppings already added.");
            return;
        }

        displayOptions("Select a topping to add:", available);
        int choice = promptMenuSelection(available.size());
        if (choice >= 0) {
            sandwich.addTopping(available.get(choice));
            slowPrint("  Added: " + available.get(choice).getName());
        }
    }

    private void runAddSauceScreen(Sandwich sandwich) {
        List<Sauce> available = menu.getSauces().stream()
                .filter(s -> !sandwich.getSauces().contains(s))
                .collect(Collectors.toList());

        if (available.isEmpty()) {
            System.out.println("  All sauces already added.");
            return;
        }

        displayOptions("Select a sauce to add:", available);
        int choice = promptMenuSelection(available.size());
        if (choice >= 0) {
            sandwich.addSauce(available.get(choice));
            slowPrint("  Added: " + available.get(choice).getName());
        }
    }

    private void checkout(Order order) {

        boolean checkingOut = true;

        while (checkingOut) {

            System.out.println(order);
            System.out.println("  y) Confirm order");
            System.out.println("  x) Remove an item");
            System.out.println("  n) Cancel order");

            String choice = scanner.nextLine().toLowerCase().trim();

            switch (choice) {

                case "x" -> {
                    runRemoveAnItemScreen(order);

                    if (order.getItems().isEmpty()) {
                        slowPrint("  Order is now empty.");
                        checkingOut = false;
                    }
                }

                case "y" -> {

                    slowPrint("  Processing order...");

                    ReceiptFileHandler receiptFileHandler = new ReceiptFileHandler();
                    Receipt receipt = new Receipt(LocalDateTime.now(), order);

                    boolean success = receiptFileHandler.generateReceipt(receipt);
                    if(success) {
                        slowPrint("  Order confirmed! Thank you for choosing Sando-Nation!");
                    } else {
                        slowPrint("  Something went wrong generating your receipt. Please see staff.");
                    }

                    checkingOut = false;
                }

                case "n" -> {
                    slowPrint("  Order cancelled.");
                    checkingOut = false;
                }

                default -> slowPrint("  Invalid input.");
            }
        }
    }

    private void runRemoveAnItemScreen(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("  No items in your order.");
            return;
        }

        // display newest first — same as Order.toString()
        List<PricedItem> reversed = new ArrayList<>(order.getItems());
        Collections.reverse(reversed);
        displayOptions("Choose the item to remove:", reversed);

        int choice = promptMenuSelection(order.getItems().size());
        if (choice >= 0) {
            // map reversed index back to original list index
            int actualIndex = order.getItems().size() - 1 - choice;
            order.removeItem(actualIndex);
            slowPrint("  Item removed.");
        }
    }

    private void displayOptions(String title, List<? extends PricedItem> options) {
        System.out.println("\n  " + title);
        System.out.println("  ─────────────────────");
        IntStream.range(0, options.size())
                .forEach(i -> System.out.printf("  %d. %s%n", i + 1, options.get(i).getDescription()));
    }

    private int promptMenuSelection(int max) {
        while (true) {
            System.out.print("  Make your selection: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice == 0) return -1;
                if (choice >= 1 && choice <= max) return choice - 1;
                System.out.println("  Please enter a number between 1 and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input — please enter a number.");
            }
        }
    }

    private boolean askWantsExtra(String topping) {
        System.out.print("  Do you want extra " + topping + "? (y/n): ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }

    private void slowPrint(String message) {

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(message);
    }

}