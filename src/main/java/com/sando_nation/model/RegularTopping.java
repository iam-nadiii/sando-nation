package com.sando_nation.model;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice() { return 0.00; }

    @Override
    public String getDescription() { return getName(); }
}