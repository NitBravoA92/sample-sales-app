package com.softwaredevone.sample_sales_app.api.v1.inventory;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private int minQuantity;

    @Column(nullable = false)
    private int maxQuantity;

    @Column(nullable = false)
    private double currentQuantity;

    public Inventory() {}

    public Inventory(Long id, Long productId, int minQuantity, int maxQuantity, double currentQuantity) {
        this.id = id;
        this.productId = productId;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.currentQuantity = currentQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public double getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(double currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}
