package com.sando_nation.ui;

import com.sando_nation.model.Menu;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();

    public static int generateOrderNumber() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public void runHomeScreen() {
        new HomeScreen(scanner, menu).run();
    }
}