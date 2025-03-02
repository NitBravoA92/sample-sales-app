package com.softwaredevone.sample_sales_app.api.v1.purchase;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    @Column(nullable = false)
    private Long productId;
    */
    @Column(nullable = false, unique = true)
    private String purchaseCode;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime purchaseDateTime;

    @Column(nullable = false)
    private String supplier;
/*
    @Column(nullable = false)
    private int quantity;
*/
    @Column(nullable = false)
    private double totalPaid;

    public Purchase() {}
    public Purchase(Long id, String purchaseCode, LocalDateTime purchaseDateTime, String supplier, double totalPaid) {
        this.id = id;
        //this.productId = productId;
        this.purchaseCode = purchaseCode;
        this.purchaseDateTime = purchaseDateTime;
        this.supplier = supplier;
        //this.quantity = quantity;
        this.totalPaid = totalPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
*/
    public String getPurchaseCode() {
        return purchaseCode;
    }

    public void setPurchaseCode(String purchaseCode) {
        this.purchaseCode = purchaseCode;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
/*
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
*/
    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }
}
