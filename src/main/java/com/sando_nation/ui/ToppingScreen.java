package com.sando_nation.ui;

import com.sando_nation.model.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ToppingScreen {
    private final Scanner       scanner;
    private final Menu          menu;
    private final DisplayHelper display;

    public ToppingScreen(Scanner scanner, Menu menu, DisplayHelper display) {
        this.scanner = scanner;
        this.menu    = menu;
        this.display = display;
    }

    public void runRemoveToppingScreen(Sandwich sandwich) {
        while (true) {
            display.displayOptions("Select a topping to remove (0 when done):",
                    sandwich.getRegularToppings());
            System.out.println("  0. Done");
            int choice = display.promptMenuSelection(sandwich.getRegularToppings().size());
            if (choice == -1) break;
            RegularTopping topping = sandwich.getRegularToppings().get(choice);
            sandwich.removeTopping(topping);
            DisplayHelper.slowPrint("  Removed: " + topping.getName());
        }
    }

    public void runRemoveSauceScreen(Sandwich sandwich) {
        while (true) {
            display.displayOptions("Select a sauce to remove (0 when done):",
                    sandwich.getSauces());
            System.out.println("  0. Done");
            int choice = display.promptMenuSelection(sandwich.getSauces().size());
            if (choice == -1) break;
            Sauce sauce = sandwich.getSauces().get(choice);
            sandwich.removeSauce(sauce);
            DisplayHelper.slowPrint("  Removed: " + sauce.getName());
        }
    }

    public void runAddToppingScreen(Sandwich sandwich) {
        List<RegularTopping> available = menu.getToppings().stream()
                .filter(t -> !sandwich.getRegularToppings().contains(t))
                .collect(Collectors.toList());

        if (available.isEmpty()) {
            System.out.println("  All toppings already added.");
            return;
        }

        display.displayOptions("Select a topping to add:", available);
        int choice = display.promptMenuSelection(available.size());
        if (choice >= 0) {
            sandwich.addTopping(available.get(choice));
            DisplayHelper.slowPrint("  Added: " + available.get(choice).getName());
        }
    }

    public void runAddSauceScreen(Sandwich sandwich) {
        List<Sauce> available = menu.getSauces().stream()
                .filter(s -> !sandwich.getSauces().contains(s))
                .collect(Collectors.toList());

        if (available.isEmpty()) {
            System.out.println("  All sauces already added.");
            return;
        }

        display.displayOptions("Select a sauce to add:", available);
        int choice = display.promptMenuSelection(available.size());
        if (choice >= 0) {
            sandwich.addSauce(available.get(choice));
            DisplayHelper.slowPrint("  Added: " + available.get(choice).getName());
        }
    }

    public void runRemoveSideScreen(Sandwich sandwich) {
        System.out.println("\n  Your sandwich comes with the following sides:");
        sandwich.getSides().forEach(s -> System.out.println("    + " + s.getName() + " (included)"));

        while (!sandwich.getSides().isEmpty()) {
            display.displayOptions("Select a side to remove (0 when done):", sandwich.getSides());
            System.out.println("  0. Done");
            int choice = display.promptMenuSelection(sandwich.getSides().size());
            if (choice == -1) break;
            Side side = sandwich.getSides().get(choice);
            sandwich.removeSide(side);
            DisplayHelper.slowPrint("  Removed: " + side.getName());
        }

        if (sandwich.getSides().isEmpty())
            System.out.println("  No sides remaining.");
    }

    public void runCustomizeSignatureSandwichScreen(SignatureSandwich sandwich) {
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
}