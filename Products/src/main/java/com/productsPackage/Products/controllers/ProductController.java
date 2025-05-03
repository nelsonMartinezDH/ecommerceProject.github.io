package com.productsPackage.Products.controllers;


import com.productsPackage.Products.dto.ProductDto;
import com.productsPackage.Products.dto.ProductToSaveDto;
import com.productsPackage.Products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductToSaveDto productToSaveDto) {
        return ResponseEntity.ok(productService.saveProducto(productToSaveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductToSaveDto productToSaveDto) {
        return ResponseEntity.ok(productService.updateProductoById(id, productToSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductoById(id);
        return ResponseEntity.noContent().build();
    }

}
