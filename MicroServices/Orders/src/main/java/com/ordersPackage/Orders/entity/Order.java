package com.ordersPackage.Orders.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long userID;

    @Column
    private Long productID;

    @Column
    private Integer quantity;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderState status;
}
