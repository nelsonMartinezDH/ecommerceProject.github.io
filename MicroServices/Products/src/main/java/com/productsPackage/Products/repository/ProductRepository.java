package com.productsPackage.Products.repository;

import com.productsPackage.Products.dto.ProductDto;
import com.productsPackage.Products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    //Query Methods

    //Simples
    List<Product> findByName(String name);
    List<Product> findByDescription(String description);
    List<Product> findByPrice(float price);
    List<Product> findByStock(int stock);

    //Compuestos
    List<Product> findByNameAndPrice(String name, float price);
    List<Product> findByNameAndStock(String name, int stock);
    List<Product> findByPriceAndStock(float price, int stock);

}
