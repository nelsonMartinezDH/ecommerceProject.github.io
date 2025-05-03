package com.ordersPackage.Orders.repository;

import com.ordersPackage.Orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);
    Optional<Order> deleteOrderById(Long id);

    //Query Methods

    //Simples
    List<Order> findByUserID(Long userID);
    List<Order> findByProductID(Long productID);
    List<Order> findByQuantity(Integer quantity);
    List<Order> findByStatus(String status);

    //Compuestos
    List<Order> findByProductIDAndStatus(Long productID, String status);
    List<Order> findByUserIDAndProductID(Long userID, Long productID);
    List<Order> findByProductIDAndQuantity(Long productID, Integer quantity);
}
