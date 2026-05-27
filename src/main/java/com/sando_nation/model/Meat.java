package com.sando_nation.model;

public class Meat extends PremiumTopping {

    public Meat(String name, double priceFour, double priceEight, double priceTwelve,
                double extraPriceFour, double extraPriceEight, double extraPriceTwelve) {
        super(name, priceFour, priceEight, priceTwelve,
                extraPriceFour, extraPriceEight, extraPriceTwelve);
    }

    @Override
    public String getDescription() { return "Meat: " + getName(); }
}