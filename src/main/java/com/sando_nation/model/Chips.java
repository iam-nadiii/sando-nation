package com.sando_nation.model;

public class Chips extends MenuItem {
        public Chips(String name, double price) {
            super(name, price);
        }


    @Override
    public String getDescription() { return getName(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  --- Chips ---\n");
        sb.append("  Brand  : ").append(getName()).append("\n");
        sb.append(String.format("  Subtotal: $%.2f", getPrice())).append("\n");
        return sb.toString();
    }
    }

