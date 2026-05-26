package com.sando_nation.model;

public class Meat extends Topping{
        double priceFour, priceEight, priceTwelve, extraPriceFour, extraPriceEight, extraPriceTwelve;
        public String size;
        public boolean wantsExtra;

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public boolean isWantsExtra() {
            return wantsExtra;
        }

        public void setWantsExtra(boolean wantsExtra) {
            this.wantsExtra = wantsExtra;
        }

        public Meat (String name, double priceFour, double priceEight, double priceTwelve,
                       double extraPriceFour, double extraPriceEight, double extraPriceTwelve) {
            super(name);
            this.priceFour        = priceFour;
            this.priceEight       = priceEight;
            this.priceTwelve      = priceTwelve;
            this.extraPriceFour   = extraPriceFour;
            this.extraPriceEight  = extraPriceEight;
            this.extraPriceTwelve = extraPriceTwelve;
        }

        public double getPriceFour() {
            return priceFour;
        }

        public void setPriceFour(double priceFour) {
            this.priceFour = priceFour;
        }

        public double getPriceEight() {
            return priceEight;
        }

        public void setPriceEight(double priceEight) {
            this.priceEight = priceEight;
        }

        public double getPriceTwelve() {
            return priceTwelve;
        }

        public void setPriceTwelve(double priceTwelve) {
            this.priceTwelve = priceTwelve;
        }

        public double getExtraPriceFour() {
            return extraPriceFour;
        }

        public void setExtraPriceFour(double extraPriceFour) {
            this.extraPriceFour = extraPriceFour;
        }

        public double getExtraPriceEight() {
            return extraPriceEight;
        }

        public void setExtraPriceEight(double extraPriceEight) {
            this.extraPriceEight = extraPriceEight;
        }

        public double getExtraPriceTwelve() {
            return extraPriceTwelve;
        }

        public void setExtraPriceTwelve(double extraPriceTwelve) {
            this.extraPriceTwelve = extraPriceTwelve;
        }

        public double calculatePrice(String size, boolean wantsExtra){
            if(size.equalsIgnoreCase("4 inch")){
                if (wantsExtra){
                    return priceFour;
                }
                return extraPriceFour;
            }

            if(size.equalsIgnoreCase("8 inch")){
                if (wantsExtra){
                    return priceEight;
                }
                return extraPriceEight;
            }

            if (size.equalsIgnoreCase("12 inch")){
                if (wantsExtra){
                    return priceTwelve;
                }
                return extraPriceTwelve;
            }
            return 0;
        }

         @Override
        public double getPrice(){
            return calculatePrice(this.size, this.wantsExtra);
        }

        @Override
        public String toString() {
            return "Cheese{" +
                    "priceFour=" + priceFour +
                    ", priceEight=" + priceEight +
                    ", priceTwelve=" + priceTwelve +
                    ", extraPriceFour=" + extraPriceFour +
                    ", extraPriceEight=" + extraPriceEight +
                    ", extraPriceTwelve=" + extraPriceTwelve +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


