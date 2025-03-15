package com.softwaredevone.sample_sales_app.api.v1.products;

import com.softwaredevone.sample_sales_app.exceptions.ResourceNotFoundException;
import com.softwaredevone.sample_sales_app.serialization.ApiResponse;
import com.softwaredevone.sample_sales_app.serialization.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        productService = productService;
    }

    @GetMapping
    public ApiResponse<Product> getProducts(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "10") int pageSize) {

        List<Product> data = productService.getAllProducts();
        Pagination pagination = new Pagination(page, pageSize);
        ApiResponse<Product> response = new ApiResponse<>(data, data.size(), pagination);

        return response;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getOneProduct(id);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productCreated = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreated);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @PatchMapping("/{id}")
    public Product updateProductPartially(@PathVariable Long id, @RequestBody Map<String, Object> selectedDataProduct) {
        return productService.updateProductPartially(id, selectedDataProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
