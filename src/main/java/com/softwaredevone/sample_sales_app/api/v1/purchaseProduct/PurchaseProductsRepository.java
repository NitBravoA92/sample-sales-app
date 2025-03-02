package com.softwaredevone.sample_sales_app.api.v1.purchaseProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseProductsRepository extends JpaRepository <PurchaseProducts, Long> {

    // get all products by purchaseId
    List<PurchaseProducts> findAllByPurchaseId(Long purchaseId);

    // get info about a product by productId
    PurchaseProducts findByProductId(Long productId);
}
