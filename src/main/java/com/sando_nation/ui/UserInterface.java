package com.sando_nation.ui;

import com.sando_nation.model.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final Menu    menu    = new Menu();

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
        System.out.println("  Goodbye!");
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
                  4) Checkout
                  0) Cancel Order
                Enter command: \s""");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    Sandwich sandwich = buildSandwich();
                    order.addItem(sandwich);
                    System.out.println("\n  Sandwich added!");
                    System.out.println(sandwich);
                }
                case "2" ->{
                    Drink drink = buildDrink();
                    order.addItem(drink);
                    System.out.println("\n  Drink added!");
                    System.out.println(drink);
                }
                case "3" ->{
                    Chips chips = buildChips();
                    order.addItem(chips);
                    System.out.println("\n Chips added!");
                    System.out.println(chips);
                }
                case "4" -> {
                    checkout(order);
                    inOrder = false;
                }
                case "0" -> {
                    System.out.println("  Order cancelled.");
                    inOrder = false;
                }
                default -> System.out.println("  Invalid input.");
            }
        }
    }

    private Chips buildChips() {
        displayOptions("Select a brand of chips:", menu.getChips());
        Chips selected = menu.getChips().get(chooseAMenuItem(menu.getChips().size()));
        return selected;
    }

    private Drink buildDrink() {
        Drink drink = new Drink();

        // pick the drink flavor
        displayOptions("Select a drink:", menu.getDrinks());
        Drink selected = menu.getDrinks().get(chooseAMenuItem(menu.getDrinks().size()));

        // pick the size
        System.out.println("\n  Select a size:");
        System.out.println("  ─────────────────────");
        System.out.println("  1. Small");
        System.out.println("  2. Medium");
        System.out.println("  3. Large");
        int sizeChoice = chooseAMenuItem(3);
        switch (sizeChoice) {
            case 1 -> selected.setSize("small");
            case 2 -> selected.setSize("medium");
            case 3 -> selected.setSize("large");
            default -> System.out.println("Invalid input. Please select a number between 1-3.");
        }

        return selected;
    }

    private Sandwich buildSandwich() {
        Sandwich sandwich = new Sandwich();

        // size
        displayOptions("Select a size:", menu.getSizes());
        SandwichSize size = menu.getSizes().get(chooseAMenuItem(menu.getSizes().size()));
        sandwich.setSandwichSize(size);

        // bread
        displayOptions("Select your bread:", menu.getBreads());
        Bread bread = menu.getBreads().get(chooseAMenuItem(menu.getBreads().size()));
        sandwich.setBread(bread);

        // meat
        displayOptions("Select your meat:", menu.getMeats());
        Meat meat = menu.getMeats().get(chooseAMenuItem(menu.getMeats().size()));
        meat.setWantsExtra(getUserWantsExtra(meat.getName()));
        sandwich.setMeat(meat);

        // cheese
        displayOptions("Select your cheese:", menu.getCheeses());
        Cheese cheese = menu.getCheeses().get(chooseAMenuItem(menu.getCheeses().size()));
        cheese.setWantsExtra(getUserWantsExtra(cheese.getName()));
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
        boolean removingToppings = true;
        while (removingToppings) {
            displayOptions("Select a topping to remove (0 when done):", sandwich.getRegularToppings());
            System.out.println("  0. Done");
            int choice = chooseAMenuItem(sandwich.getRegularToppings().size());
            if (choice == -1) {
                removingToppings = false;
            } else {
                RegularTopping topping = sandwich.getRegularToppings().get(choice);
                sandwich.removeTopping(topping);
                System.out.println("  Removed: " + topping.getName());
            }
        }
    }

    private void runRemoveSauceScreen(Sandwich sandwich) {
        boolean removingSauces = true;
        while (removingSauces) {
            displayOptions("Select a sauce to remove (0 when done):", sandwich.getSauces());
            System.out.println("  0. Done");
            int choice = chooseAMenuItem(sandwich.getSauces().size());
            if (choice == -1) {
                removingSauces = false;
            } else {
                Sauce sauce = sandwich.getSauces().get(choice);
                sandwich.removeSauce(sauce);
                System.out.println("  Removed: " + sauce.getName());
            }
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
                    slowPrint("  Order confirmed! Thank you for choosing Sando-Nation!");

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

        displayOptions("Choose the item to remove:", order.getItems());
        int choice = chooseAMenuItem(order.getItems().size());
        if (choice >= 0) {
            order.removeItem(choice);
            System.out.println("  Item removed.");
        }
    }

    private void displayOptions(String title, List<? extends PricedItem> options) {
        System.out.println("\n  " + title);
        System.out.println("  ─────────────────────");
        IntStream.range(0, options.size())
                .forEach(i -> System.out.printf("  %d. %s%n", i + 1, options.get(i).getDescription()));
    }

    private int chooseAMenuItem(int max) {
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

    private boolean getUserWantsExtra(String topping) {
        System.out.print("  Do you want extra " + topping + "? (y/n): ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }

    private static final int DELAY = 3000;

    private void slowPrint(String message) {

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(message);
    }

}