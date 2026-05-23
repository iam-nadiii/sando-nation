package com.sando_nation.ui;

import com.sando_nation.model.Order;

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

            String choice = scanner.nextLine().toLowerCase().trim();
            switch (choice) {
                case "1" -> runSandwichesMenuScreen();
                case "a" -> System.out.println("  [Action] Logic executed in Child A.");
                case "r" -> inChildA = false;
                default -> System.out.println("  Invalid input.");
            }
        }
    }

    private void runSandwichesMenuScreen() {

        Order order = new Order();
        do {
            System.out.println("Select bread: ");
            System.out.println("A. White\n" +
                    "B. Wheat\n" +
                    "C. Rye\n" +
                    "D. Wrap");

            String choice = scanner.nextLine().toLowerCase().trim();

            switch (choice) {
                case "A" -> addBread("white");
                case "a" -> System.out.println("  [Action] Logic executed in Child A.");
                case "r" -> {
                    return;
                }
                default -> System.out.println("  Invalid input.");

            }

        } while (true);
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

    // LEVEL 3: Grandchild (Only accessible via Child A)
    public void runGrandchildScreen() {
        boolean inGrandchild = true;
        while (inGrandchild) {
            System.out.println("\n    [LEVEL 3: GRANDCHILD SCREEN]");
            System.out.print("""
                \n    Options:
                    A) Perform Grandchild Action
                    B) Back to Child Screen A
                    Enter command: \s""");

            String choice = scan.nextLine().toLowerCase().trim();
            switch (choice) {
                case "a" -> System.out.println("    [Action] Logic executed in Grandchild.");
                case "b" -> inGrandchild = false;
                default -> System.out.println("    Invalid input.");
            }
        }
    }
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