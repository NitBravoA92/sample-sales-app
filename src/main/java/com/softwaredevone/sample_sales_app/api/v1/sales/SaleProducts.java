package com.softwaredevone.sample_sales_app.api.v1.sales;

import jakarta.persistence.*;

@Entity
public class SaleProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long saleId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double subtotal;

    public SaleProducts() {
    }

    public SaleProducts(Long id, Long productId, Long saleId, int quantity, double subtotal) {
        this.id = id;
        this.productId = productId;
        this.saleId = saleId;
        this.quantity = quantity;
        this.subtotal = subtotal;
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

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
