package com.softwaredevone.sample_sales_app.api.v1.purchaseProduct;

import com.softwaredevone.sample_sales_app.api.v1.purchase.Purchase;
import com.softwaredevone.sample_sales_app.exceptions.ResourceNotFoundException;
import com.softwaredevone.sample_sales_app.serialization.ApiResponse;
import com.softwaredevone.sample_sales_app.serialization.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchase/products")
public class PurchaseProductsController {

    @Autowired
    PurchaseProductServices purchaseProductService;

    public PurchaseProductsController(PurchaseProductServices service) {
        this.purchaseProductService = service;
    }

    @GetMapping
    public ApiResponse<PurchaseProducts> getProductsByPurchaseId(@RequestParam Long purchaseId, @RequestParam(defaultValue = "1") int page,
                                             @RequestParam(defaultValue = "10") int pageSize) {

        List<PurchaseProducts> data = purchaseProductService.getAllProductsByPurchaseId(purchaseId);
        Pagination pagination = new Pagination(page, pageSize);
        ApiResponse<PurchaseProducts> response = new ApiResponse<>(data, data.size(), pagination);

        return response;
    }

    @GetMapping("/{id}")
    public PurchaseProducts getPurchaseProductById(@PathVariable Long id) {
        return purchaseProductService.getOnePurchaseProduct(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PurchaseProducts> deleteProductFromPurchase(@PathVariable Long id) {
        purchaseProductService.deleteAProductFromPurchase(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<PurchaseProducts> createPurchaseProduct(@RequestBody PurchaseProducts newItem) {
        PurchaseProducts itemCreated = purchaseProductService.createPurchaseProduct(newItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemCreated);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
