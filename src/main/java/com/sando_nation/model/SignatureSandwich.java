package com.sando_nation.model;

public class SignatureSandwich extends Sandwich {
    private String signatureName;

    public SignatureSandwich(String signatureName, Bread bread, SandwichSize size,
                             Meat meat, Cheese cheese, boolean isToasted) {
        super(); // calls Sandwich constructor
        this.signatureName = signatureName;
        setBread(bread);
        setSandwichSize(size);
        setMeat(meat);
        setCheese(cheese);
        setToasted(isToasted);
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


//Optional Bonus) Challenge Yourself
//If you have time and want to challenge yourself, consider the following:
//Create several Signature Sandwiches that are a template for what the customer can
//order. The customer could then customize the existing toppings to either remove or add
//more toppings to the sandwich.
//        HINT: Signature Sandwiches could be managed by creating custom classes that inherit
//from the Sandwich class.
//Signature Sandwiches might include:
//        • BLT
//o 8" white bread
//o Bacon
//o Cheddar
//o Lettuce
//o Tomato
//o Ranch
//o Toasted


//• Philly Cheese Steak
//o 8" white bread
//o Steak
//o American Cheese
//o Peppers
//o Mayo
//o Toasted