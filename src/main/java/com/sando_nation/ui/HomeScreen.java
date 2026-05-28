package com.sando_nation.ui;

import com.sando_nation.model.Menu;

import java.util.Scanner;

public class HomeScreen {
    private final Scanner      scanner;
    private final OrderScreen  orderScreen;

    public HomeScreen(Scanner scanner, Menu menu) {
        this.scanner     = scanner;
        this.orderScreen = new OrderScreen(scanner, menu);
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("""
                \n============================
                  Welcome to Sando-Nation!!
                ============================
                  1) New Order
                  0) Exit Application
                Enter command: \s""");

            switch (scanner.nextLine().trim()) {
                case "1" -> orderScreen.run();
                case "0" -> isRunning = false;
                default  -> System.out.println("  Invalid input.");
            }
        }
        DisplayHelper.slowPrint("  Goodbye!");
    }
}