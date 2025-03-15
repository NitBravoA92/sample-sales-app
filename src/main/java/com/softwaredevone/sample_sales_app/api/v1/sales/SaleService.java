package com.softwaredevone.sample_sales_app.api.v1.sales;

import com.softwaredevone.sample_sales_app.api.v1.purchase.Purchase;
import com.softwaredevone.sample_sales_app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public List<Sale> getAllSales() {
        List<Sale> saleList = new ArrayList<>();
        saleList = repository.findAll();

        return saleList;
    }

    public Sale getOneSale(Long id) {
        Sale sale = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sale with id: " + id + " was not found"));

        return sale;
    }

    public Sale createSale(Sale sale) {
        return repository.save(sale);
    }

    public void deleteSale(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sale with id: " + id + "was not found");
        }

        repository.deleteById(id);
    }
}
