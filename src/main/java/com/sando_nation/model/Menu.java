package com.sando_nation.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Bread> breads;
    private List<SandwichSize> sandwichSizes;
    private List<RegularTopping> regularToppings;
    private List<Sauce> sauces;
    private List<Meat> meats;
    private List<Cheese> cheeses;
    private List<Drink> drinks;
    private List<Chips> chips;
    private List<Side> sides;
    private List<SignatureSandwich> signatureSandwiches;

    public Menu() {
        initializeBreads();

        initializeSandwichSizes();

        initializeMeats();

        initializeCheeses();

        initializeRegularToppings();

        initializeSauces();

        initializeDrinks();

        initializeChips();

        initializeSides();


        signatureSandwiches = new ArrayList<>();
        initializeBLTSandwich();
        initializePhillySandwich();

    }

    private void initializePhillySandwich() {
        SignatureSandwich philly = new SignatureSandwich(
                "Philly Cheese Steak",
                new Bread("White"),
                new Meat("Steak",  1.00, 2.00, 3.00, 0.50, 1.00, 1.50),
                new Cheese("American", 0.75, 1.50, 2.25, 0.30, 0.60, 0.90),
                true
        );
        philly.initializeToppings(new ArrayList<>());
        philly.addTopping(new RegularTopping("Peppers"));
        philly.initializeSauces(new ArrayList<>());
        philly.addSauce(new Sauce("Mayo"));
        signatureSandwiches.add(philly);
    }

    private void initializeBLTSandwich() {
        SignatureSandwich blt = new SignatureSandwich(
                "BLT",
                new Bread("White"),
                new Meat("Bacon",  1.00, 2.00, 3.00, 0.50, 1.00, 1.50),
                new Cheese("Cheddar", 0.75, 1.50, 2.25, 0.30, 0.60, 0.90),
                true
        );
        blt.initializeToppings(new ArrayList<>());
        blt.addTopping(new RegularTopping("Lettuce"));
        blt.addTopping(new RegularTopping("Tomatoes"));
        blt.initializeSauces(new ArrayList<>());
        blt.addSauce(new Sauce("Ranch"));
        signatureSandwiches.add(blt);
    }


    private void initializeSides() {
        sides = new ArrayList<>();
        sides.add(new Side("Au Jus"));
        sides.add(new Side("Sauce"));
    }

    private void initializeChips() {
        chips = new ArrayList<>();
        chips.add(new Chips("Lays", 1.50));
        chips.add(new Chips("Cheetos", 1.50));
        chips.add(new Chips("Fritos", 1.50));
    }

    private void initializeDrinks() {
        drinks = new ArrayList<>();
        drinks.add(new Drink("Coke", 2, 2.50,3));
        drinks.add(new Drink("Sprite", 2, 2.50,3));
        drinks.add(new Drink("Fanta", 2, 2.50,3));
        drinks.add(new Drink("Ginger Ale", 2, 2.50,3));
    }

    private void initializeSauces() {
        sauces = new ArrayList<>();
        sauces.add(new Sauce("Mayo"));
        sauces.add(new Sauce("Mustard"));
        sauces.add(new Sauce("Ketchup"));
        sauces.add(new Sauce("Ranch"));
        sauces.add(new Sauce("Thousand islands"));
        sauces.add(new Sauce("Vinaigrette"));
    }

    private void initializeRegularToppings() {
        regularToppings = new ArrayList<>();
        regularToppings.add(new RegularTopping("Lettuce"));
        regularToppings.add(new RegularTopping("Peppers"));
        regularToppings.add(new RegularTopping("Onions"));
        regularToppings.add(new RegularTopping("Tomatoes"));
        regularToppings.add(new RegularTopping("Jalapenos"));
        regularToppings.add(new RegularTopping("Cucumbers"));
        regularToppings.add(new RegularTopping("Pickles"));
        regularToppings.add(new RegularTopping("Guacamole"));
        regularToppings.add(new RegularTopping("Mushrooms"));
    }

    private void initializeCheeses() {
        cheeses = new ArrayList<>();
        cheeses.add(new Cheese("American",  0.75, 1.50, 2.25, 0.30, 0.60, 0.90));
        cheeses.add(new Cheese("Provolone", 0.75, 1.50, 2.25, 0.30, 0.60, 0.90));
        cheeses.add(new Cheese("Cheddar",   0.75, 1.50, 2.25, 0.30, 0.60, 0.90));
        cheeses.add(new Cheese("Swiss",     0.75, 1.50, 2.25, 0.30, 0.60, 0.90));
    }

    private void initializeMeats() {
        meats = new ArrayList<>();
        meats.add(new Meat("Steak",      1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Ham",        1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Salami",     1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Roast Beef", 1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Chicken",    1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Bacon",      1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
    }

    private void initializeSandwichSizes() {
        sandwichSizes = new ArrayList<>();
        sandwichSizes.add(new SandwichSize("4 inch",  5.50));
        sandwichSizes.add(new SandwichSize("8 inch",  7.00));
        sandwichSizes.add(new SandwichSize("12 inch", 8.50));
    }

    private void initializeBreads() {
        breads = new ArrayList<>();
        breads.add(new Bread("White"));
        breads.add(new Bread("Wheat"));
        breads.add(new Bread("Rye"));
        breads.add(new Bread("Wrap"));
    }

    public List<Bread>          getBreads()   { return breads; }
    public List<SandwichSize>   getSizes()    { return sandwichSizes; }
    public List<Meat>           getMeats()    { return meats; }
    public List<Cheese>         getCheeses()  { return cheeses; }
    public List<RegularTopping> getToppings() { return regularToppings; }
    public List<Sauce> getSauces() { return sauces; }
    public List<Drink> getDrinks() { return drinks; }
    public List<Chips> getChips() { return chips;}
    public List<Side> getSides() { return sides; }
    public List<SignatureSandwich> getSignatureSandwiches(){return signatureSandwiches;}

}
