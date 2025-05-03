package com.productsPackage.Products.service;

import com.productsPackage.Products.dto.ProductDto;
import com.productsPackage.Products.mappers.ProductMapper;
import com.productsPackage.Products.dto.ProductToSaveDto;
import com.productsPackage.Products.entity.Product;
import com.productsPackage.Products.exception.ProductNotFoundException;
import com.productsPackage.Products.repository.ProductRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto saveProducto(ProductToSaveDto productToSaveDto) {
        Product productToSave = productMapper.productToSaveDtoToProductEntity(productToSaveDto);
        Product productSaved = productRepository.save(productToSave);
        return productMapper.productEntityToProductDto(productSaved);
    }


    @Override
    public ProductDto findById(Long id) throws ProductNotFoundException {
        Optional<Product> producto = productRepository.findById(id);

        if (producto.isEmpty())
            throw new ProductNotFoundException("Producto con ID " + id + " no encontrado");

        return productMapper.productEntityToProductDto(producto.get());
    }

    @Override
    public List<ProductDto> findByNameAndPrice(String name, float price) throws ProductNotFoundException {
        List<Product> productFound = productRepository.findByNameAndPrice(name, price);

        if (productFound.isEmpty())
            throw new ProductNotFoundException("No se encontraron productos que empiecen por: " + name);

        List<ProductDto> productsToReturn = new ArrayList<>();

        productFound.forEach(producto -> {
            ProductDto productoMapeado = productMapper.productEntityToProductDto(producto);
            productsToReturn.add(productoMapeado);
        });

        return productsToReturn;
    }

    @SneakyThrows
    @Override
    public ProductDto updateProductoById(Long id, ProductToSaveDto productToSaveDto) {
        Optional<Product> productoConsultado = productRepository.findById(id);

        if (productoConsultado.isEmpty())
            throw new ProductNotFoundException("Producto con ID " + id + " no encontrado");

        Product product = productoConsultado.get();

        if (product.getName() != null) product.setName(product.getName());
        if (product.getStock() != null) product.setStock(product.getStock());
        if (product.getPrice() != null) product.setPrice(product.getPrice());

        Product updatedPrice = productRepository.save(product);

        return productMapper.productEntityToProductDto(updatedPrice);
    }

    @SneakyThrows
    @Override
    public void deleteProductoById(Long id) {
        Optional<Product> productToDelete = productRepository.findById(id);

        if (productToDelete.isEmpty())
            throw new ProductNotFoundException("Producto con ID " + id + " no existe");

        productRepository.deleteById(id);
    }

    @SneakyThrows
    @Override
    public List<ProductDto> findProductoByNombre(String name) {
        List<Product> productoMatch = productRepository.findByName(name);

        if (productoMatch.isEmpty())
            throw new ProductNotFoundException("No se encontraron productos que empiecen por: " + name);

        List<ProductDto> productsToReturn = new ArrayList<>();

        productoMatch.forEach(producto -> {
            ProductDto productoMapeado = productMapper.productEntityToProductDto(producto);
            productsToReturn.add(productoMapeado);
        });

        return productsToReturn;
    }
}
