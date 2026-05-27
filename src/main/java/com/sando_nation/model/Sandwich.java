package com.sando_nation.model;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements PricedItem {
    private SandwichSize        sandwichSize;
    private Bread               bread;
    private Meat                meat;
    private Cheese              cheese;
    private List<RegularTopping> regularToppings;
    private boolean             isToasted;
    private List<Sauce> sauces;

    public Sandwich() {
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }

    public SandwichSize getSandwichSize()               { return sandwichSize; }
    public Bread        getBread()                      { return bread; }
    public Meat         getMeat()                       { return meat; }
    public Cheese       getCheese()                     { return cheese; }
    public List<RegularTopping> getRegularToppings()    { return regularToppings; }
    public boolean      isToasted()                     { return isToasted; }
    public void         setToasted(boolean toasted)     { this.isToasted = toasted; }
    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSandwichSize(SandwichSize size) {
        this.sandwichSize = size;
        if (meat   != null) meat.setSize(size.getSize());
        if (cheese != null) cheese.setSize(size.getSize());
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
        if (sandwichSize != null) meat.setSize(sandwichSize.getSize());
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
        if (sandwichSize != null) cheese.setSize(sandwichSize.getSize());
    }

    public void initializeToppings(List<RegularTopping> allToppings) {
        this.regularToppings = new ArrayList<>(allToppings);
    }

    public void removeTopping(RegularTopping topping) {
        regularToppings.remove(topping);
    }

    public void initializeSauces(List<Sauce> allSauces) {
        this.sauces = new ArrayList<>(allSauces);
    }

    public void removeSauce(Sauce sauce) {
        sauces.remove(sauce);
    }

    @Override
    public String getName() { return "Sandwich"; }

    @Override
    public double getPrice() {
        double total = 0.00;
        if (sandwichSize != null) total += sandwichSize.getPrice();
        if (meat         != null) total += meat.getPrice();
        if (cheese       != null) total += cheese.getPrice();
        return total;
    }

    @Override
    public String getDescription() { return toString(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  --- Sandwich ---\n");
        sb.append("  Size   : ").append(sandwichSize != null ? sandwichSize.getDescription() : "none").append("\n");
        sb.append("  Bread  : ").append(bread  != null ? bread.getName()  : "none").append("\n");
        sb.append("  Meat   : ").append(meat   != null ? meat.getName()   : "none");
        if (meat != null) sb.append(meat.isWantsExtra() ? " (extra)" : "");
        sb.append("\n");
        sb.append("  Cheese : ").append(cheese != null ? cheese.getName() : "none");
        if (cheese != null) sb.append(cheese.isWantsExtra() ? " (extra)" : "");
        sb.append("\n");
        if (!regularToppings.isEmpty()) {
            sb.append("  Toppings:\n");
            regularToppings.forEach(t -> sb.append("    + ").append(t.getName()).append("\n"));
        }
        if (!sauces.isEmpty()) {
            sb.append("  Sauces:\n");
            sauces.forEach(t -> sb.append("    + ").append(t.getName()).append("\n"));
        }
        sb.append("  Toasted: ").append(isToasted ? "Yes" : "No").append("\n");
        sb.append(String.format("  Subtotal: $%.2f", getPrice())).append("\n");
        return sb.toString();
    }
}