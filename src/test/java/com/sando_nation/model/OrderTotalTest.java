package com.sando_nation.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTotalTest {

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order(1000);
    }

    @Test
    public void newOrder_isEmpty() {
        assertTrue(order.getItems().isEmpty());
    }

    @Test
    public void newOrder_totalIsZero() {
        assertEquals(0.00, order.getTotal(), 0.001);
    }

    @Test
    public void addItem_increasesSize() {
        order.addItem(new Chips("Lays", 1.50));
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void getTotal_singleChips() {
        order.addItem(new Chips("Lays", 1.50));
        assertEquals(1.50, order.getTotal(), 0.001);
    }

    @Test
    public void getTotal_multipleItems() {
        order.addItem(new Chips("Lays",    1.50));
        order.addItem(new Chips("Cheetos", 1.50));
        assertEquals(3.00, order.getTotal(), 0.001);
    }

    @Test
    public void removeItem_decreasesSize() {
        order.addItem(new Chips("Lays", 1.50));
        order.removeItem(0);
        assertTrue(order.getItems().isEmpty());
    }


    @Test
    public void removeItem_invalidIndex_doesNothing() {
        order.addItem(new Chips("Lays", 1.50));
        order.removeItem(5);
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void getOrderNumber_returnsCorrectNumber() {
        assertEquals(1000, order.getOrderNumber());
    }
}