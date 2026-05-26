package com.sando_nation.model;


import java.util.ArrayList;
import java.util.HashMap;

public class Sandwich implements MenuItem{

    private String size;
    private String breadType;
    private Topping cheese;
    private Topping sauce;
    private Topping extraMeat;
    private ArrayList<Topping> regularTopping;

    Sandwich(){
        regularTopping = new ArrayList<>();
    }

    public Topping getCheese() {
        return cheese;
    }

    public void setCheese(Topping cheese) {
        this.cheese = cheese;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public Topping getSauce() {
        return sauce;
    }

    public void setSauce(Topping sauce) {
        this.sauce = sauce;
    }

    public Topping getExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(Topping extraMeat) {
        this.extraMeat = extraMeat;
    }

    public ArrayList<Topping> getRegularTopping() {
        return regularTopping;
    }

    public void addARegularToppingItem(Topping topping) {
        regularTopping.add(topping);
    }

    public void removeRegualrToppingItem(Topping topping){
        regularTopping.remove(topping);
    }


    public double getPrice(){

        return 0;
    }

    public double calculateTotalSandwichPrice(){
        return 0;
    }
}

