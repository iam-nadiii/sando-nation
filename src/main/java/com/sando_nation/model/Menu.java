package com.sando_nation.model;

import java.util.*;

public class Menu {
    List<Bread> breads;
    List<SandwichSize> sandwichSizes;
    List<RegularTopping> regularToppings;
    List<Sauce> sauces;
    List<Meat> meats;
    List<Cheese> cheeses;

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
    }

    public List<Bread>          getBreads()   { return breads; }
    public List<SandwichSize>   getSizes()    { return sandwichSizes; }
    public List<Meat>           getMeats()    { return meats; }
    public List<Cheese>         getCheeses()  { return cheeses; }
    public List<RegularTopping> getToppings() { return regularToppings; }
    public List<Sauce> getSauces() { return sauces; }

}
