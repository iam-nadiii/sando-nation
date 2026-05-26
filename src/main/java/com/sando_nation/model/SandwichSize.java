package com.sando_nation.model;

public class SandwichSize extends MenuItem{
    private double breadPrice;
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public SandwichSize(String size, double breadPrice){
        this.breadPrice = breadPrice;
        this.size = size;
    }

    public double getBreadPrice() {
        return breadPrice;
    }

    public void setBreadPrice(double breadPrice) {
        this.breadPrice = breadPrice;
    }

    @Override
    public double getPrice(){
        return breadPrice;
    }

    @Override
    public String getDescription(){
        return getSize();
    }
}
