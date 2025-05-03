package com.ordersPackage.Orders.service;

import com.ordersPackage.Orders.dto.OrderDto;
import com.ordersPackage.Orders.dto.OrderToSaveDto;
import com.ordersPackage.Orders.exception.OrderNotFoundException;

import java.util.List;

public interface OrderService {
    OrderDto saveOrder(OrderToSaveDto productToSaveDto);
    OrderDto findById(Long id) throws OrderNotFoundException;
    List<OrderDto> findByProductIDAndQuantity(Long productID, Integer quantity) throws OrderNotFoundException;
    OrderDto updateOrderById(Long id, OrderToSaveDto orderToSaveDto) throws OrderNotFoundException;
    OrderDto updatePatchOrderById(Long id, OrderToSaveDto orderToSaveDto) throws OrderNotFoundException;
    void deleteOrderById(Long id) throws OrderNotFoundException;
    List<OrderDto> findOrderByStatus(String name) throws OrderNotFoundException;
}
