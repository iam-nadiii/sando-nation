package com.sando_nation.model;

public class RegularTopping extends MenuItem {

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public String getDescription() { return getName(); }
}