package com.sando_nation.model;

public class Drink extends MenuItem{

    private double priceSmall, priceMedium, priceLarge;

    public Drink(String name, double priceSmall, double priceMedium, double priceLarge){
        super(name);
        this.priceSmall = priceSmall;
        this.priceMedium = priceMedium;
        this.priceLarge = priceLarge;
    }


    public double getPriceSmall() {
        return priceSmall;
    }

    public void setPriceSmall(double priceSmall) {
        this.priceSmall = priceSmall;
    }

    public double getPriceMedium() {
        return priceMedium;
    }

    public void setPriceMedium(double priceMedium) {
        this.priceMedium = priceMedium;
    }

    public double getPriceLarge() {
        return priceLarge;
    }

    public void setPriceLarge(double priceLarge) {
        this.priceLarge = priceLarge;
    }

    @Override
    public String getDescription() {
        return String.format("%s - S: $%.2f | M: $%.2f | L: $%.2f",
                getName(), this.priceSmall, this.priceMedium, this.priceLarge);
    }

    @Override
    public double getPrice(){
        return calculatePrice(getSize());
    }

    private double calculatePrice(String size) {
        if(size == null) return 0;
        if(size.equals("small")) return priceSmall;
        if(size.equals("medium")) return priceMedium;
        if(size.equals("large")) return priceLarge;
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  --- Drink ---\n");
        sb.append("  Flavor : ").append(getName()).append("\n");
        sb.append("  Size   : ").append(getSize() != null ? getSize() : "none").append("\n");
        sb.append(String.format("  Subtotal: $%.2f", getPrice())).append("\n");
        return sb.toString();
    }


}
