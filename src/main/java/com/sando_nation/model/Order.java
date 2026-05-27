package com.sando_nation.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Order {
    private int            orderNumber;
    private List<Sandwich> sandwiches;

    public Order() {
        this.sandwiches = new ArrayList<>();
    }

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.sandwiches  = new ArrayList<>();
    }

    public int            getOrderNumber()  { return orderNumber; }
    public List<Sandwich> getSandwiches()   { return sandwiches; }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void removeAnItem(int index) {
        if (index >= 0 && index < sandwiches.size()) {
            sandwiches.remove(index);
            System.out.println("  Item removed from order.");
        }
    }

    public double getTotal() {
        return sandwiches.stream()
                .mapToDouble(Sandwich::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=============================\n");
        sb.append("  Order #").append(orderNumber).append("\n");
        sb.append("=============================\n");
//        List<Sandwich> reversed = new ArrayList<>(sandwiches);
//        Collections.reverse(reversed);
        IntStream.range(0, sandwiches.size())
                .forEach(i ->
                        sb.append(String.format("%d. %s%n",
                                i + 1,
                                sandwiches.get(i).toString()))
                );
        sb.append("─────────────────────────────\n");
        sb.append(String.format("  Order Total: $%.2f", getTotal())).append("\n");
        sb.append("=============================\n");
        return sb.toString();
    }
}