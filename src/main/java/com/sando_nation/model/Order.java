package com.sando_nation.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private double total;

    Order(){

        items = new ArrayList<>();
        total = 0;
    }

    public void addMenuItem(MenuItem item){
        items.add(item);
        total += item.getPrice();
    }

    public void removeMenuItem(MenuItem item){
        items.remove(item);
        total -= item.getPrice();
    }
}
