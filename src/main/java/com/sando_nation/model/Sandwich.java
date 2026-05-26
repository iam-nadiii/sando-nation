package com.sando_nation.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sandwich implements PricedItem {
    SandwichSize sandwichSize;
    Bread bread;
    Meat meat;
    Cheese cheese;
    List<Topping> regularTopping;

    public Sandwich(SandwichSize sandwichSize, Bread bread, Meat meat,
                    Cheese cheese, List<Topping> regularToppings){

    }

    public Sandwich(){}

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public List<Topping> getRegularTopping() {
        return regularTopping;
    }

    public void setRegularTopping(List<Topping> regularTopping) {
        this.regularTopping = regularTopping;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "sandwichSize=" + sandwichSize.getDescription() +
                ", bread=" + bread.getDescription() +
                ", meat=" + meat.getDescription() +
                ", cheese=" + cheese.getDescription() +
                ", regularTopping=" + regularTopping.toString() +
                '}';
    }

    @Override
    public double getPrice() {
        return bread.getPrice() + meat.getPrice() + cheese.getPrice() + sandwichSize.getPrice();
    }

    @Override
    public String getDescription(){
        return toString();
    }

}

