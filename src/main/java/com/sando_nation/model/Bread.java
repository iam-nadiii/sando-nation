package com.sando_nation.model;

public class Bread extends MenuItem{

    public Bread(String name){
        super(name);
    }

    @Override
    public String getDescription(){
        return this.getName();
    }
}
