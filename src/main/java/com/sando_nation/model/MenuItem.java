package com.sando_nation.model;

public abstract class MenuItem implements PricedItem {
    private String name;
    private String size;
    private double price;

    public MenuItem() {}

    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem(String name, double price) {
        this.name  = name;
        this.price = price;
    }
    public String getName()           { return name; }
    public void   setName(String name){ this.name = name; }

    public String getSize()           { return size; }
    public void   setSize(String size){ this.size = size; }

    public double getPrice()             { return price; }
    public void   setPrice(double price) { this.price = price; }


    @Override
    public abstract String getDescription();
}