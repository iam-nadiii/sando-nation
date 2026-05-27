package com.sando_nation.model;


public class Bread extends MenuItem {

    public Bread(String name) {
        super(name);
    }

    @Override
    public double getPrice() { return 0.00; }

    @Override
    public String getDescription() { return getName(); }
}
