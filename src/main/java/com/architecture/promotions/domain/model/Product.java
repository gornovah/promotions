package com.architecture.promotions.domain.model;

public class Product {
    private final int id;
    private final String size;
    private final String colour;
    private final int price;

    public Product(int id, String size, String colour, int price) {
        this.id = id;
        this.size = size;
        this.colour = colour;
        this.price = price;
    }
}
