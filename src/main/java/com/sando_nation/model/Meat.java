package com.sando_nation.model;

public class Meat extends Topping{
        double priceFour, priceEight, priceTwelve, extraPriceFour, extraPriceEight, extraPriceTwelve;

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


