package com.softwaredevone.sample_sales_app.api.v1.sales;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String saleCode;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime saleDateTime;

    @Column(nullable = false)
    private String client;

    @Column(nullable = false)
    private String sellerCode;

    @Column(nullable = false)
    private double subtotal;

    @Column(nullable = false)
    private double taxes;

    @Column(nullable = false)
    private double totalPaid;

    public Sale() {
    }

    public Sale(Long id, String saleCode, LocalDateTime saleDateTime, String client, String sellerCode, double subtotal, double taxes, double totalPaid) {
        this.id = id;
        this.saleCode = saleCode;
        this.saleDateTime = saleDateTime;
        this.client = client;
        this.sellerCode = sellerCode;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.totalPaid = totalPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(LocalDateTime saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }
}
