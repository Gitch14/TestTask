package org.example.facade.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Order {
    private String side;
    private int price;
    private int size;
    private String type;


    public Order(String side, int price, int size, String type) {
        this.side = side;
        this.price = price;
        this.size = size;
        this.type = type;
    }

    public Order(String side, String type) {
        this.side = side;
        this.type = type;
    }

    public Order(String side, String type, int size) {
        this.side = side;
        this.type = type;
        this.size = size;
    }
}
