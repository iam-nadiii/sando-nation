package com.sando_nation.ui;

import com.sando_nation.model.*;

import java.util.Scanner;

public class HomeScreen {
    private final Scanner     scanner;
    private final Menu        menu;
    private final OrderScreen orderScreen;

    private static final int WIDTH = 84;

    public HomeScreen(Scanner scanner, Menu menu) {
        this.scanner     = scanner;
        this.menu        = menu;
        this.orderScreen = new OrderScreen(scanner, menu);
    }

    public void run() {
        printMenu();  // ← print once at the start
        boolean isRunning = true;
        while (isRunning) {
            System.out.print(
                    box('╔', '═', '╗') + "\n" +
                            "║" + center("", WIDTH) + "║\n" +
                            "║" + center("1) New Order                          0) Exit Application", WIDTH) + "║\n" +
                            "║" + center("", WIDTH) + "║\n" +
                            box('╚', '═', '╝') + "\n" +
                            "Enter command: "
            );

            switch (scanner.nextLine().trim()) {
                case "1" -> orderScreen.run();
                case "0" -> isRunning = false;
                default  -> System.out.println("  Invalid input.");
            }
        }
        DisplayHelper.slowPrint("  Goodbye!");
    }

    private void printMenu() {
        System.out.println(box('╔', '═', '╗'));
        System.out.println("║" + center("Welcome to Sando-Nation!!", WIDTH) + "║");
        System.out.println("║" + center("Your Custom Sandwich Experience", WIDTH) + "║");
        System.out.println(box('╚', '═', '╝'));
        System.out.println();
        System.out.println(box('┌', '─', '┐'));
        System.out.println("│" + center("OUR MENU", WIDTH) + "│");
        System.out.println(box('└', '─', '┘'));

        printSizes();
        printBreads();
        printMeats();
        printCheeses();
        printRegularToppings();
        printSauces();
        printSides();
        printDrinks();
        printChips();
        printSignatureSandwiches();
    }

    // ─── helpers ────────────────────────────────────────────────────────────

    private static String box(char left, char fill, char right) {
        return left + String.valueOf(fill).repeat(WIDTH) + right;
    }

    private static String divider() {
        return "  " + "─".repeat(WIDTH - 2);
    }

    private static String section(String title) {
        return "  " + title + "\n" + divider();
    }

    private static String center(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }

    // ─── section printers ───────────────────────────────────────────────────

    private void printSizes() {
        System.out.println(section("SANDWICH SIZES"));
        menu.getSizes().forEach(s -> System.out.printf(
                "  %-10s %s  $%.2f%n",
                s.getDescription(),
                ".".repeat(55),
                s.getPrice()));
    }

    private void printBreads() {
        System.out.println();
        System.out.println(divider());
        System.out.printf("  %-20s %-40s %s%n",
                "BREADS",
                "White | Wheat | Rye | Wrap",
                "Included with every size");
        System.out.println(divider());
    }

    private void printMeats() {
        System.out.println();
        System.out.println(divider());
        System.out.println("  PREMIUM TOPPINGS");
        System.out.println(divider());
        System.out.printf("  %-40s %-14s %-14s %s%n",
                "MEATS", "4 inch", "8 inch", "12 inch");
        System.out.println(divider());

        // get first meat for pricing — all meats share same price
        Meat m = menu.getMeats().get(0);
        System.out.printf("  %-40s $%-13.2f $%-13.2f $%.2f%n",
                "",
                m.calculatePrice("4 inch",  false),
                m.calculatePrice("8 inch",  false),
                m.calculatePrice("12 inch", false));
        System.out.printf("  %-40s +$%-12.2f +$%-12.2f +$%.2f%n",
                "Extra",
                m.calculatePrice("4 inch",  true) - m.calculatePrice("4 inch",  false),
                m.calculatePrice("8 inch",  true) - m.calculatePrice("8 inch",  false),
                m.calculatePrice("12 inch", true) - m.calculatePrice("12 inch", false));
        System.out.println(divider());

        // print meat names in a row
        StringBuilder sb = new StringBuilder("  ");
        menu.getMeats().forEach(meat -> sb.append(String.format("%-15s", meat.getName())));
        System.out.println(sb);
    }

    private void printCheeses() {
        System.out.println();
        System.out.printf("  %-40s %-14s %-14s %s%n",
                "CHEESES", "4 inch", "8 inch", "12 inch");
        System.out.println(divider());

        // get first cheese for pricing — all cheeses share same price
        Cheese c = menu.getCheeses().get(0);
        System.out.printf("  %-40s $%-13.2f $%-13.2f $%.2f%n",
                "",
                c.calculatePrice("4 inch",  false),
                c.calculatePrice("8 inch",  false),
                c.calculatePrice("12 inch", false));
        System.out.printf("  %-40s +$%-12.2f +$%-12.2f +$%.2f%n",
                "Extra",
                c.calculatePrice("4 inch",  true) - c.calculatePrice("4 inch",  false),
                c.calculatePrice("8 inch",  true) - c.calculatePrice("8 inch",  false),
                c.calculatePrice("12 inch", true) - c.calculatePrice("12 inch", false));
        System.out.println(divider());

        // print cheese names in a row
        StringBuilder sb = new StringBuilder("  ");
        menu.getCheeses().forEach(cheese -> sb.append(String.format("%-15s", cheese.getName())));
        System.out.println(sb);
    }

    private void printRegularToppings() {
        System.out.println();
        System.out.printf("  %-60s %s%n", "REGULAR TOPPINGS", "FREE with any size");
        System.out.println(divider());

        StringBuilder sb = new StringBuilder("  ");
        for (int i = 0; i < menu.getToppings().size(); i++) {
            sb.append(String.format("%-15s", menu.getToppings().get(i).getName()));
            if ((i + 1) % 5 == 0) sb.append("\n  ");
        }
        System.out.println(sb);
    }

    private void printSauces() {
        System.out.println();
        System.out.printf("  %-60s %s%n", "SAUCES", "FREE with any size");
        System.out.println(divider());

        StringBuilder sb = new StringBuilder("  ");
        for (int i = 0; i < menu.getSauces().size(); i++) {
            sb.append(String.format("%-20s", menu.getSauces().get(i).getName()));
            if ((i + 1) % 4 == 0) sb.append("\n  ");
        }
        System.out.println(sb);
    }

    private void printSides() {
        System.out.println();
        System.out.printf("  %-60s %s%n", "SIDES", "FREE with any size");
        System.out.println(divider());

        StringBuilder sb = new StringBuilder("  ");
        menu.getSides().forEach(s -> sb.append(String.format("%-15s", s.getName())));
        System.out.println(sb);
    }

    private void printDrinks() {
        System.out.println();
        System.out.printf("  %-35s %-15s %-15s %s%n",
                "DRINKS", "Small", "Medium", "Large");
        System.out.println(divider());

        // get first drink for pricing — all drinks share same price
        Drink d = menu.getDrinks().get(0);
        System.out.printf("  %-35s $%-14.2f $%-14.2f $%.2f%n",
                "",
                d.getPriceSmall(),
                d.getPriceMedium(),
                d.getPriceLarge());
        System.out.println(divider());

        // print drink names in a row
        StringBuilder sb = new StringBuilder("  ");
        menu.getDrinks().forEach(drink -> sb.append(String.format("%-15s", drink.getName())));
        System.out.println(sb);
    }

    private void printChips() {
        System.out.println();
        System.out.printf("  %-60s %s%n", "CHIPS", "$1.50");
        System.out.println(divider());

        StringBuilder sb = new StringBuilder("  ");
        menu.getChips().forEach(c -> sb.append(String.format("%-15s", c.getName())));
        System.out.println(sb);
    }

    private void printSignatureSandwiches() {
        System.out.println();
        System.out.println(section("SIGNATURE SANDWICHES"));

        menu.getSignatureSandwiches().forEach(s -> {
            double minPrice = s.getMeat().calculatePrice("4 inch",  false)
                    + s.getCheese().calculatePrice("4 inch",  false)
                    + menu.getSizes().get(0).getPrice();
            double maxPrice = s.getMeat().calculatePrice("12 inch", false)
                    + s.getCheese().calculatePrice("12 inch", false)
                    + menu.getSizes().get(2).getPrice();

            System.out.println();
            System.out.printf("  %-55s from $%.2f - $%.2f%n",
                    s.getSignatureName(), minPrice, maxPrice);
            System.out.println(divider());
            System.out.printf("    Bread   : %s%n", s.getBread().getName());
            System.out.printf("    Meat    : %s%n", s.getMeat().getName());
            System.out.printf("    Cheese  : %s%n", s.getCheese().getName());

            String toppings = s.getRegularToppings().stream()
                    .map(RegularTopping::getName)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("None");
            System.out.printf("    Toppings: %s%n", toppings);

            String sauces = s.getSauces().stream()
                    .map(Sauce::getName)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("None");
            System.out.printf("    Sauce   : %s%n", sauces);
            System.out.printf("    Toasted : %s%n", s.isToasted() ? "Yes" : "No");
            System.out.println("    Customize to your liking — add or remove any topping or sauce");
        });

        System.out.println();
    }
}