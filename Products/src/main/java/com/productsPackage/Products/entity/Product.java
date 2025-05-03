package com.productsPackage.Products.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Stock")
    private Integer stock;
}
