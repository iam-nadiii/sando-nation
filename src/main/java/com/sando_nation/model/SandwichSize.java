package com.sando_nation.model;

public class SandwichSize extends MenuItem {


    public SandwichSize(String size, double breadPrice) {
        super(size,breadPrice);
        setSize(size);

    }

    @Override
    public String getDescription() { return getSize(); }
}