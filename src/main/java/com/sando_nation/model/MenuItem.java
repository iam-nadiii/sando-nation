package com.sando_nation.model;

public abstract class MenuItem implements PricedItem {
    private String name;
    private String size;

    public MenuItem() {}

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName()           { return name; }
    public void   setName(String name){ this.name = name; }

    public String getSize()           { return size; }
    public void   setSize(String size){ this.size = size; }

    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}