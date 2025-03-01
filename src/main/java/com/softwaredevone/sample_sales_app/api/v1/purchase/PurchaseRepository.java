package com.softwaredevone.sample_sales_app.api.v1.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository <Purchase, Long> {}
