package com.architecture.promotions.domain.model;

public class DiscountedProduct {
    private int id;
    private String size;
    private String colour;
    private float initialPrice;
    private float discountedPrice;

    public DiscountedProduct(int id, String size, String colour, float initialPrice, float discountedPrice) {
        this.id = id;
        this.size = size;
        this.colour = colour;
        this.initialPrice = initialPrice;
        this.discountedPrice = discountedPrice;
    }
}
