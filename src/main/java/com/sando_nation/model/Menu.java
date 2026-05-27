package com.sando_nation.model;

import java.util.*;

public class Menu {
    List<Bread> breads;
    List<SandwichSize> sandwichSizes;
    List<RegularTopping> regularToppings;
    List<Sauce> sauces;
    List<Meat> meats;
    List<Cheese> cheeses;
    List<Drink> drinks;
    List<Chips> chips;
    List<SignatureSandwich> signatureSandwiches;

    public Menu() {
        breads = new ArrayList<>();
        breads.add(new Bread("White"));
        breads.add(new Bread("Wheat"));
        breads.add(new Bread("Rye"));
        breads.add(new Bread("Wrap"));

        sandwichSizes = new ArrayList<>();
        sandwichSizes.add(new SandwichSize("4 inch",  5.50));
        sandwichSizes.add(new SandwichSize("8 inch",  7.00));
        sandwichSizes.add(new SandwichSize("12 inch", 8.50));

        meats = new ArrayList<>();
        meats.add(new Meat("Steak",      1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Ham",        1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Salami",     1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Roast Beef", 1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Chicken",    1.00, 2.00, 3.00, 0.50, 1.00, 1.50));
        meats.add(new Meat("Bacon",      1.00, 2.00, 3.00, 0.50, 1.00, 1.50));

        cheeses = new ArrayList<>();
        cheeses.add(new Cheese("American",  0.75, 1.50, 2.25, 0.30, 0.60, 0.90));
        cheeses.add(new Cheese("Provolone", 0.75, 1.50, 2.25, 0.30, 0.60, 0.90));
        cheeses.add(new Cheese("Cheddar",   0.75, 1.50, 2.25, 0.30, 0.60, 0.90));
        cheeses.add(new Cheese("Swiss",     0.75, 1.50, 2.25, 0.30, 0.60, 0.90));

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

        sauces = new ArrayList<>();
        sauces.add(new Sauce("mayo"));
        sauces.add(new Sauce("mustard"));
        sauces.add(new Sauce("ketchup"));
        sauces.add(new Sauce("ranch"));
        sauces.add(new Sauce("thousand islands"));
        sauces.add(new Sauce("vinaigrette"));

        drinks = new ArrayList<>();
        drinks.add(new Drink("Coke", 2, 2.50,3));
        drinks.add(new Drink("Sprite", 2, 2.50,3));
        drinks.add(new Drink("Fanta", 2, 2.50,3));
        drinks.add(new Drink("Ginger Ale", 2, 2.50,3));

        chips = new ArrayList<>();
        chips.add(new Chips("Lays", 1.50));
        chips.add(new Chips("Cheetos", 1.50));
        chips.add(new Chips("Fritos", 1.50));

        // find items by name from existing lists
        Bread      white   = breads.stream().filter(b -> b.getName().equals("White")).findFirst().get();
        SandwichSize eight = sandwichSizes.stream().filter(s -> s.getSize().equals("8 inch")).findFirst().get();
        Meat       bacon   = meats.stream().filter(m -> m.getName().equals("Bacon")).findFirst().get();
        Cheese     cheddar = cheeses.stream().filter(c -> c.getName().equals("Cheddar")).findFirst().get();
        Meat       steak   = meats.stream().filter(m -> m.getName().equals("Steak")).findFirst().get();
        Cheese     american = cheeses.stream().filter(c -> c.getName().equals("American")).findFirst().get();

        signatureSandwiches = new ArrayList<>();

        SignatureSandwich blt = new SignatureSandwich("BLT", white, eight, bacon, cheddar, true);
        blt.initializeToppings(regularToppings);
        blt.removeTopping(regularToppings.stream().filter(t -> t.getName().equals("Peppers")).findFirst().get());
        blt.removeTopping(regularToppings.stream().filter(t -> t.getName().equals("Onions")).findFirst().get());
        blt.removeTopping(regularToppings.stream().filter(t -> t.getName().equals("Jalapenos")).findFirst().get());
        blt.removeTopping(regularToppings.stream().filter(t -> t.getName().equals("Cucumbers")).findFirst().get());
        blt.removeTopping(regularToppings.stream().filter(t -> t.getName().equals("Pickles")).findFirst().get());
        blt.removeTopping(regularToppings.stream().filter(t -> t.getName().equals("Guacamole")).findFirst().get());
        blt.removeTopping(regularToppings.stream().filter(t -> t.getName().equals("Mushrooms")).findFirst().get());
        signatureSandwiches.add(blt);


        SignatureSandwich philly = new SignatureSandwich("Philly Cheese Steak", white, eight, steak, american, true);
        philly.initializeToppings(regularToppings);
        philly.removeTopping(regularToppings.stream().filter(t -> !t.getName().equals("Peppers")).findFirst().get());
        signatureSandwiches.add(philly);

    }

    public List<Bread>          getBreads()   { return breads; }
    public List<SandwichSize>   getSizes()    { return sandwichSizes; }
    public List<Meat>           getMeats()    { return meats; }
    public List<Cheese>         getCheeses()  { return cheeses; }
    public List<RegularTopping> getToppings() { return regularToppings; }
    public List<Sauce> getSauces() { return sauces; }
    public List<Drink> getDrinks() { return drinks; }
    public List<Chips> getChips() { return chips;}
    public List<SignatureSandwich> getSignatureSandwiches(){return signatureSandwiches;}

}
