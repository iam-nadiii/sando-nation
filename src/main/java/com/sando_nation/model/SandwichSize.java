package com.sando_nation.model;

public class SandwichSize extends MenuItem {
    private double breadPrice;

    public SandwichSize(String size, double breadPrice) {
        super(size);
        setSize(size);
        this.breadPrice = breadPrice;
    }

    public double getBreadPrice()            { return breadPrice; }
    public void   setBreadPrice(double price){ this.breadPrice = price; }

    @Override
    public double getPrice() { return breadPrice; }

    @Override
    public String getDescription() { return getSize(); }
}