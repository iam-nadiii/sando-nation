package com.sando_nation.data;

import com.sando_nation.model.Order;

import java.time.*;

public class Receipt {
    private LocalDateTime  time;
    private Order order;

    public Receipt(LocalDateTime time, Order order){
        this.order = order;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "time=" + time +
                ", order=" + order +
                '}';
    }
}



//(yyyyMMdd-hhmmss.txt - i.e. 20230329-121523.txt)