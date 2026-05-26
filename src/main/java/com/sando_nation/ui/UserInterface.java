package com.sando_nation.ui;

import com.sando_nation.model.Order;
import com.sando_nation.model.Sandwich;

import java.util.Scanner;

public class UserInterface {
    public Scanner scanner = new Scanner(System.in);

    public void runHomeScreen() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("""
                \n[Welcome to Sando-Nation!!]
                1) New Order
                0) Exit Application
                Enter command: \s""");


            String choice = scanner.nextLine().toLowerCase().trim();
            switch (choice) {
                case "1" -> runOrderScreen();
                case "0" -> isRunning = false;
                default -> System.out.println("Invalid input.");
            }
        }
    }


    public void runOrderScreen() {
        boolean inChildA = true;
        while (inChildA) {
            System.out.print("""
                \n  [LEVEL 2: CHILD SCREEN A]
                  1) Add Sandwich
                  2) Add Drink
                  3) Add Chips
                  4) Checkout
//                  5) View cart
                  0) Cancel Order
                  R) Return to home screen
                  Enter command: \s""");

            String choice = scanner.nextLine().toUpperCase().trim();
            switch (choice) {
                case "1" -> runSandwichesMenuScreen();
                case "A" -> System.out.println("  [Action] Logic executed in Child A.");
                case "R" -> inChildA = false;
                default -> System.out.println("  Invalid input.");
            }
        }
    }

    private void runSandwichesMenuScreen() {
        boolean isRunning = true;

        Order order = new Order();
        Sandwich sandwich = new Sandwich();
        order.addMenuItem(sandwich);
        runBreadChoiceScreen(sandwich, isRunning);

        runProteinChoiceScreen(sandwich);

        runCheeseChoiceScreen(sandwich);


    }

    private void runCheeseChoiceScreen(Sandwich sandwich) {
        outer:
        do {
            System.out.println("Select cheese: ");
            System.out.println("A. American\n" +
                    "B. Provolone\n" +
                    "C. Cheddar\n" +
                    "D. Swiss\n");

            String choice = scanner.nextLine().toUpperCase().trim();

            switch (choice) {
                case "A" -> {
                    sandwich.setCheese("American");
                    break outer;
                }
                case "B" -> sandwich.setCheese("Provolone");
                case "C" -> sandwich.setCheese("Cheddar");
                case "D" -> sandwich.setCheese("Swiss");
                case "r" -> {
                    return;
                }
                default -> System.out.println("  Invalid input.");

            }

        } while (true);
    }

    private void runProteinChoiceScreen(Sandwich sandwich) {
        outer:
        do {
            System.out.println("Select protein: ");
            System.out.println("A. Steak\n" +
                    "B. Ham\n" +
                    "C. Salami\n" +
                    "D. Roast beef\n" +
                    "E. Chicken\n" +
                    "F. Bacon");

            String choice = scanner.nextLine().toUpperCase().trim();

            switch (choice) {
                case "A" -> {
                    sandwich.setProtein("Steak");
                    break outer;
                }
                case "B" -> {
                    sandwich.setProtein("Ham");
                    break outer;
                }
                case "C" -> sandwich.setProtein("Salami");
                case "D" -> sandwich.setProtein("Roast beef");
                case "E" -> sandwich.setProtein("Chicken");
                case "F" -> sandwich.setProtein("Bacon");
                case "r" -> {
                    return;
                }
                default -> System.out.println("  Invalid input.");

            }

        } while (true);
    }

    private void runBreadChoiceScreen(Sandwich sandwich, boolean isRunning) {
        outer:
        do {
            System.out.println("Select bread: ");
            System.out.println("A. White\n" +
                    "B. Wheat\n" +
                    "C. Rye\n" +
                    "D. Wrap");

            String choice = scanner.nextLine().toUpperCase().trim();

            switch (choice) {
                case "A" -> {
                    sandwich.setBreadType("white");
                    break outer;
                }
                case "B" -> sandwich.setBreadType("Wheat");
                case "C" -> sandwich.setBreadType("Rye");
                case "D" -> sandwich.setBreadType("Wrap");
                case "r" -> {
                    isRunning = false;
                }
                default -> System.out.println("  Invalid input.");

            }

        } while (isRunning);
    }

    private void printPrices(double priceOfSmall, double priceOfMedium, double priceOfLarge){
        System.out.println();
    }

    //• Order Screen - All entries should show the newest entries first
//o 1) Add Sandwich
//o 2) Add Drink
//o 3) Add Chips
//o 4) Checkout
//o 0) Cancel Order - delete the order and go back to the home page
//• Add Sandwich - the add sandwich screen will walk the user through several
//options to create the sandwich
//o Select your bread:
//o Sandwich size:
//o Toppings: - the user should be able to add extras of each topping
//▪ Meat:
//        ▪ Cheese:
//        ▪ Other toppings:
//        ▪ Select sauces:
//o Would you like the sandwich toasted?
//        • Add Drink - select drink size and flavor
//• Add Chips - select chip type
//• Checkout - display the order details and the price
//o Confirm - create the receipt file and go back to the home screen
//o Cancel - delete order and go back to the home screen

}



//Your application must include several screens with the listed features in order to be
//considered complete:
//        • Home Screen
//o The home screen should give the user the following options. The
//application should continue to run until the user chooses to exit.
//        ▪ 1) New Order
//▪ 0) Exit - exit the application


//• Order Screen - All entries should show the newest entries first
//o 1) Add Sandwich
//o 2) Add Drink
//o 3) Add Chips
//o 4) Checkout
//o 0) Cancel Order - delete the order and go back to the home page
//• Add Sandwich - the add sandwich screen will walk the user through several
//options to create the sandwich
//o Select your bread:
//o Sandwich size:
//o Toppings: - the user should be able to add extras of each topping
//▪ Meat:
//        ▪ Cheese:
//        ▪ Other toppings:
//        ▪ Select sauces:
//o Would you like the sandwich toasted?
//        • Add Drink - select drink size and flavor
//• Add Chips - select chip type
//• Checkout - display the order details and the price
//o Confirm - create the receipt file and go back to the home screen
//o Cancel - delete order and go back to the home screen