package com.sando_nation.model;

public abstract class PremiumTopping extends MenuItem {
    protected double priceFour, priceEight, priceTwelve;
    protected double extraPriceFour, extraPriceEight, extraPriceTwelve;
    protected boolean wantsExtra;

    public PremiumTopping(String name, double priceFour, double priceEight, double priceTwelve,
                          double extraPriceFour, double extraPriceEight, double extraPriceTwelve) {
        super(name);
        this.priceFour        = priceFour;
        this.priceEight       = priceEight;
        this.priceTwelve      = priceTwelve;
        this.extraPriceFour   = extraPriceFour;
        this.extraPriceEight  = extraPriceEight;
        this.extraPriceTwelve = extraPriceTwelve;
    }

    public boolean isWantsExtra()           { return wantsExtra; }
    public void    setWantsExtra(boolean w) { this.wantsExtra = w; }

    public double calculatePrice(String size, boolean wantsExtra) {
        if (size == null) return 0.00;
        if (size.equalsIgnoreCase("4 inch"))
            return wantsExtra ? extraPriceFour + priceFour  : priceFour;
        if (size.equalsIgnoreCase("8 inch"))
            return wantsExtra ? extraPriceEight + priceEight : priceEight;
        if (size.equalsIgnoreCase("12 inch"))
            return wantsExtra ? extraPriceTwelve + priceTwelve : priceTwelve;
        return 0.00;
    }

    @Override
    public double getPrice() {
        return calculatePrice(this.getSize(), this.wantsExtra);
    }
    @Override
    public String getDescription() { return getName(); }
}