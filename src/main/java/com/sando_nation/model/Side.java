package com.sando_nation.model;

public class Side extends MenuItem {

    public Side(String name) {
        super(name);
    }

    @Override
    public String getDescription() { return getName(); }
}