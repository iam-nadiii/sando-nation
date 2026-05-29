package com.sando_nation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Order {
    private int              orderNumber;
    private List<PricedItem> items;  // ← holds anything that has a price

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.items       = new ArrayList<>();
    }

    public void addItem(PricedItem item) {
        items.add(item);
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public List<PricedItem> getItems() { return items; }


    public double getTotal() {
        return items.stream()
                .mapToDouble(PricedItem::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=============================\n");
        sb.append("  Order #").append(orderNumber).append("\n");
        sb.append("=============================\n");
        IntStream.iterate(items.size() - 1, i -> i >= 0, i -> i - 1)
                .mapToObj(items::get)
                .forEach(item -> sb.append(item.toString()).append("\n"));
        sb.append("─────────────────────────────\n");
        sb.append(String.format("  Order Total: $%.2f", getTotal())).append("\n");
        sb.append("=============================\n");
        return sb.toString();
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}