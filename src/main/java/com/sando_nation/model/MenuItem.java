package com.sando_nation.model;

public abstract class MenuItem implements PricedItem{
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuItem(){

    }

    public MenuItem(String name) {
        this.name = name;
    }

    @Override
    public double getPrice(){
        return 0;
    }

    @Override
    public String getDescription(){
        return name;
    }
}
