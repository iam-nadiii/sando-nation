package com.sando_nation.ui;

import com.sando_nation.model.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

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
        Order order = new Order();
        Menu menu = new Menu();
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
                case "1" -> {
                    Sandwich sandwich = new Sandwich();

                    displayOptions("Sandwich Sizes", menu.getSizes());
                    int userChoice = Integer.parseInt(makeASelection()) -1;
                    SandwichSize size = menu.getSizes().get(userChoice);

                    sandwich.setSandwichSize(size);
                    System.out.println(sandwich);
                }
                case "A" -> System.out.println("  [Action] Logic executed in Child A.");
                case "R" -> inChildA = false;
                default -> System.out.println("  Invalid input.");
            }
        }
    }





    private void displayOptions(String title, List<? extends PricedItem> options) {
        System.out.println("\n" + title);
        System.out.println("─────────────────────");
        IntStream.range(0, options.size())
                .forEach(i -> System.out.println((i + 1) + ". " + options.get(i).getDescription()));
    }

    private String makeASelection(){
        System.out.println("Make your selection: ");
        String choice = scanner.nextLine();

        return choice;
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