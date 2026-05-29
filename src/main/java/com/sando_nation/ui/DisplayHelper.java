package com.sando_nation.ui;

import com.sando_nation.model.PricedItem;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DisplayHelper {
    private final Scanner scanner;
    private static final int DELAY = 800;

    public DisplayHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayOptions(String title, List<? extends PricedItem> options) {
        System.out.println("\n  " + title);
        System.out.println("  ─────────────────────");
        IntStream.range(0, options.size())
                .forEach(i -> System.out.printf("  %d. %s%n",
                        i + 1, options.get(i).getDescription()));
    }

    public int promptMenuSelection(int max) {
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

    public boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("  Invalid input — please enter y or n.");
        }
    }

    public static void slowPrint(String message) {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(message);
    }
}