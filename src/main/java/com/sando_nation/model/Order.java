package com.sando_nation.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<PricedItem> items;
    private double total;

    public Order(){

        items = new ArrayList<>();
        total = 0;
    }

    public void addMenuItem(PricedItem item){
        items.add(item);
        total += item.getPrice();
    }

    public void removeMenuItem(PricedItem item){
        items.remove(item);
        total -= item.getPrice();
    }

}
