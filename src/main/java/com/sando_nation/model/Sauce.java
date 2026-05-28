package com.sando_nation.model;

public class Sauce extends MenuItem{

        public Sauce(String name) {
            super(name);
        }

        @Override
        public double getPrice() { return 0.00; }

        @Override
        public String getDescription() { return getName(); }
    }
