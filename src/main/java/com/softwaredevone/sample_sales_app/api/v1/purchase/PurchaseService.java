package com.softwaredevone.sample_sales_app.api.v1.purchase;

import com.softwaredevone.sample_sales_app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    public List<Purchase> getAllPurchase() {
        List<Purchase> purchaseList = new ArrayList<>();
        purchaseList = repository.findAll();

        return purchaseList;
    }

    public Purchase getOnePurchase(Long id) {
        Purchase purchase = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Purchase with id: " + id + " was not found"));

        return purchase;
    }

    public Purchase createPurchase(Purchase purchase) {
        return repository.save(purchase);
    }

    public Purchase updatePurchase(Long id, Purchase purchase) {
        Purchase SelectedPurchase = this.getOnePurchase(id);

        // update purchase
        //SelectedPurchase.setProductId(purchase.getProductId());
        SelectedPurchase.setPurchaseCode(purchase.getPurchaseCode());
        SelectedPurchase.setPurchaseDateTime(purchase.getPurchaseDateTime());
        SelectedPurchase.setSupplier(purchase.getSupplier());
        //SelectedPurchase.setQuantity(purchase.getQuantity());
        SelectedPurchase.setTotalPaid(purchase.getTotalPaid());

        return repository.save(SelectedPurchase);
    }

    public Purchase updatePurchasePartially(Long id, Map<String, Object> dataUpdated) {
        Purchase SelectedPurchase = this.getOnePurchase(id);

        // update selected purchase data
        dataUpdated.forEach((key, value) -> {
            switch (key) {
                /*
                case "productId":
                    SelectedPurchase.setProductId((Long) value);
                    break;
                    */
                case "purchaseCode":
                    SelectedPurchase.setPurchaseCode((String) value);
                    break;
                case "purchaseDateTime":
                    SelectedPurchase.setPurchaseDateTime((LocalDateTime) value);
                    break;
                case "supplier":
                    SelectedPurchase.setSupplier((String) value);
                    break;
                    /*
                    case "quantity":
                    SelectedPurchase.setQuantity((int) value);
                    break;
                    */
                case "totalPaid":
                    SelectedPurchase.setTotalPaid((double) value);
                    break;
            }
        });

        return repository.save(SelectedPurchase);
    }

    public void deletePurchase(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Purchase with id: " + id + "was not found");
        }

        repository.deleteById(id);
    }
}
