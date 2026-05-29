package com.sando_nation.ui;

import com.sando_nation.model.*;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sando_nation.ui.DisplayHelper.slowPrint;

public class OrderBuilder {
    private final Scanner       scanner;
    private final Menu          menu;
    private final DisplayHelper display;
    private final ToppingScreen toppingScreen;

    public OrderBuilder(Scanner scanner, Menu menu, DisplayHelper display) {
        this.scanner       = scanner;
        this.menu          = menu;
        this.display       = display;
        this.toppingScreen = new ToppingScreen(scanner, menu, display);
    }

    public Sandwich buildSandwich() {
        Sandwich sandwich = new Sandwich();
        selectSize(sandwich);
        selectBread(sandwich);
        selectMeat(sandwich);
        selectCheese(sandwich);
        selectToppings(sandwich);
        selectSauces(sandwich);
        selectSides(sandwich);
        selectToasted(sandwich);
        return sandwich;
    }

    private void selectSize(Sandwich sandwich) {
        display.displayOptions("Select a size:", menu.getSizes());
        SandwichSize size = menu.getSizes().get(display.promptMenuSelection(menu.getSizes().size()));
        sandwich.setSandwichSize(size);
        slowPrint(sandwich.toString());
    }

    private void selectBread(Sandwich sandwich) {
        display.displayOptions("Select your bread:", menu.getBreads());
        Bread bread = menu.getBreads().get(display.promptMenuSelection(menu.getBreads().size()));
        sandwich.setBread(bread);
        slowPrint(sandwich.toString());
    }

    private void selectMeat(Sandwich sandwich) {
        display.displayOptions("Select your meat:", menu.getMeats());
        Meat meat = menu.getMeats().get(display.promptMenuSelection(menu.getMeats().size()));
        meat.setWantsExtra(display.askYesNo("Do you want extra " + meat.getName() + "?"));
        sandwich.setMeat(meat);
        slowPrint(sandwich.toString());
    }

    private void selectCheese(Sandwich sandwich) {
        display.displayOptions("Select your cheese:", menu.getCheeses());
        Cheese cheese = menu.getCheeses().get(display.promptMenuSelection(menu.getCheeses().size()));
        cheese.setWantsExtra(display.askYesNo("Do you want extra " + cheese.getName() + "?"));
        sandwich.setCheese(cheese);
        slowPrint(sandwich.toString());
    }

    private void selectToppings(Sandwich sandwich) {
        sandwich.initializeToppings(menu.getToppings());
        toppingScreen.runRemoveToppingScreen(sandwich);
        slowPrint(sandwich.toString());
    }

    private void selectSauces(Sandwich sandwich) {
        sandwich.initializeSauces(menu.getSauces());
        toppingScreen.runRemoveSauceScreen(sandwich);
        slowPrint(sandwich.toString());
    }

    private void selectSides(Sandwich sandwich) {
        toppingScreen.runRemoveSideScreen(sandwich);
        slowPrint(sandwich.toString());
    }

    private void selectToasted(Sandwich sandwich) {
        sandwich.setToasted(display.askYesNo("Would you like it toasted?"));
        slowPrint(sandwich.toString());
    }

    public Drink buildDrink() {
        display.displayOptions("Select a drink:", menu.getDrinks());
        Drink template = menu.getDrinks().get(display.promptMenuSelection(menu.getDrinks().size()));
        Drink selected = new Drink(template.getName(), template.getPriceSmall(),
                template.getPriceMedium(), template.getPriceLarge());

        System.out.println("\n  Select a size:");
        System.out.println("  ─────────────────────");
        System.out.println("  1. Small");
        System.out.println("  2. Medium");
        System.out.println("  3. Large");
        int sizeChoice = display.promptMenuSelection(3);
        switch (sizeChoice) {
            case 0 -> selected.setSize("small");
            case 1 -> selected.setSize("medium");
            case 2 -> selected.setSize("large");
        }

        return selected;
    }

    public Chips buildChips() {
        display.displayOptions("Select a brand of chips:", menu.getChips());
        return menu.getChips().get(display.promptMenuSelection(menu.getChips().size()));
    }

    public SignatureSandwich buildSignatureSandwich() {
        display.displayOptions("Select a signature sandwich:", menu.getSignatureSandwiches());
        SignatureSandwich selected = menu.getSignatureSandwiches()
                .get(display.promptMenuSelection(menu.getSignatureSandwiches().size()));

        display.displayOptions("Select a size:", menu.getSizes());
        SandwichSize size = menu.getSizes()
                .get(display.promptMenuSelection(menu.getSizes().size()));

        SignatureSandwich copy = new SignatureSandwich(
                selected.getSignatureName(),
                selected.getBread(),
                selected.getMeat(),
                selected.getCheese(),
                selected.isToasted()
        );
        copy.setSandwichSize(size);
        copy.initializeToppings(new ArrayList<>(selected.getRegularToppings()));
        copy.initializeSauces(new ArrayList<>(selected.getSauces()));

        System.out.println(copy);

        if (display.askYesNo("Would you like to customize it?")) {
            toppingScreen.runCustomizeSignatureSandwichScreen(copy);
        }

        return copy;
    }
}