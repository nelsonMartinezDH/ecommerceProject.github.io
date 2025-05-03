package com.productsPackage.Products.mappers;

import com.productsPackage.Products.dto.ProductDto;
import com.productsPackage.Products.dto.ProductToSaveDto;
import com.productsPackage.Products.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock")
    })
    ProductDto productEntityToProductDto(Product product);

    @InheritInverseConfiguration
    Product productDtoToProductEntity(ProductDto productDto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "stock", target = "stock")
    })
    ProductToSaveDto productEntityToProductToSaveDto(Product product);

    @InheritInverseConfiguration
    Product productToSaveDtoToProductEntity(ProductToSaveDto productToSaveDto);
}
