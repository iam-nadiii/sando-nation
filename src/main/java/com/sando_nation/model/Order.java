package com.sando_nation.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int             orderNumber;
    private List<PricedItem>  pricedItems;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.pricedItems  = new ArrayList<>();
    }

    public Order(){}

    public void addPricedItem(PricedItem pricedItem) {
        pricedItems.add(pricedItem);
    }

    public List<PricedItem> getPricedItems() { return pricedItems; }
    public int getOrderNumber()           { return orderNumber; }

    public double getTotal() {
        double total = 0.00;
        for (PricedItem i : pricedItems) {
            total += i.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNumber).append("\n");
        sb.append("─────────────────────\n");
        for (PricedItem p : pricedItems) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("─────────────────────\n");
        sb.append("Order Total: $")
                .append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}
