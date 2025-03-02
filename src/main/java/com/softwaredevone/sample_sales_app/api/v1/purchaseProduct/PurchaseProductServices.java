package com.softwaredevone.sample_sales_app.api.v1.purchaseProduct;

import com.softwaredevone.sample_sales_app.api.v1.purchase.Purchase;
import com.softwaredevone.sample_sales_app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseProductServices {

    @Autowired
    private PurchaseProductsRepository repository;

    public PurchaseProductServices(PurchaseProductsRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseProducts> getAllProductsByPurchaseId(Long purchaseId) {
        List<PurchaseProducts> productList = new ArrayList<>();
        productList = repository.findAllByPurchaseId(purchaseId);

        return productList;
    }

    public PurchaseProducts getOnePurchaseProduct(Long id) {
        PurchaseProducts purchaseProduct = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item #" + id + " was not found in this purchase"));

        return purchaseProduct;
    }

    public PurchaseProducts createPurchaseProduct(PurchaseProducts purchaseProduct) {
        return repository.save(purchaseProduct);
    }

    public void deleteAProductFromPurchase(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Item #: " + id + "was not found in the Purchase");
        }

        repository.deleteById(id);
    }
}
