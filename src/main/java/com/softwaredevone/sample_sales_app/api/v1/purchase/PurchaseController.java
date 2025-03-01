package com.softwaredevone.sample_sales_app.api.v1.purchase;

import com.softwaredevone.sample_sales_app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<Purchase> getPurchase() {
        return purchaseService.getAllPurchase();
    }

    @GetMapping("/{id}")
    public Purchase getPurchase(@PathVariable Long id) {
        return purchaseService.getOnePurchase(id);
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
        Purchase purchaseCreated = purchaseService.createPurchase(purchase);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseCreated);
    }

    @PutMapping("/{id}")
    public Purchase updatePurchase(@PathVariable Long id, @RequestBody Purchase updatedPurchase) {
        return purchaseService.updatePurchase(id, updatedPurchase);
    }

    @PatchMapping("/{id}")
    public Purchase updatePurchasePartially(@PathVariable Long id, @RequestBody Map<String, Object> selectedDataPurchase) {
        return purchaseService.updatePurchasePartially(id, selectedDataPurchase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Purchase> deletePurchase(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
