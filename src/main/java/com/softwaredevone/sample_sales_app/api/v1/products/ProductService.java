package com.softwaredevone.sample_sales_app.api.v1.products;

import com.softwaredevone.sample_sales_app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        repository = repository;
    }

    public List<Product> getAllProducts() {
        List<Product> productsList = new ArrayList<>();
        productsList = repository.findAll();

        return productsList;
    }

    public Product getOneProduct(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " was not found"));

        return product;
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product SelectedProduct = this.getOneProduct(id);

        // update product
        SelectedProduct.setCode(product.getCode());
        SelectedProduct.setName(product.getName());
        SelectedProduct.setDescription(product.getDescription());
        SelectedProduct.setPrice(product.getPrice());

        return repository.save(SelectedProduct);
    }

    public Product updateProductPartially(Long id, Map<String, Object> dataUpdated) {
        Product SelectedProduct = this.getOneProduct(id);

        // update selected product data
        dataUpdated.forEach((key, value) -> {
            switch (key) {
                case "code":
                    SelectedProduct.setCode((String) value);
                    break;
                case "name":
                    SelectedProduct.setName((String) value);
                    break;
                case "description":
                    SelectedProduct.setDescription((String) value);
                    break;
                case "price":
                    SelectedProduct.setPrice((double) value);
                    break;
            }
        });

        return repository.save(SelectedProduct);
    }

    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Product with id: " + id + "was not found");
        }

        repository.deleteById(id);
    }
}
