package com.sando_nation.model;

public class SignatureSandwich extends Sandwich {
    private String signatureName;

    public SignatureSandwich(String signatureName, Bread bread,
                             Meat meat, Cheese cheese, boolean isToasted) {
        super();
        this.signatureName = signatureName;
        setBread(bread);
        setMeat(meat);
        setCheese(cheese);
        setToasted(isToasted);
        // size intentionally not set here — customer picks it
    }


    public String getSignatureName()                  { return signatureName; }
    public void   setSignatureName(String name)       { this.signatureName = name; }

    @Override
    public String getDescription() { return signatureName; }

    @Override
    public String toString() {
        return super.toString().replace("--- Sandwich ---", "--- " + signatureName + " ---");
    }
}


