package com.ordersPackage.Orders.controllers;

import com.ordersPackage.Orders.dto.OrderDto;
import com.ordersPackage.Orders.dto.OrderToSaveDto;
import com.ordersPackage.Orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderToSaveDto orderToSaveDto) {
        return ResponseEntity.ok(orderService.saveOrder(orderToSaveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderToSaveDto orderToSaveDto) {
        return ResponseEntity.ok(orderService.updateOrderById(id, orderToSaveDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDto> updatePatchOrder(@PathVariable Long id, @RequestBody OrderToSaveDto orderToSaveDto) {
        return ResponseEntity.ok(orderService.updatePatchOrderById(id, orderToSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }

}
