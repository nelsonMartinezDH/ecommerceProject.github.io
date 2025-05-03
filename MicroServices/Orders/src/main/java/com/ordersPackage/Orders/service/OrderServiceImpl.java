package com.ordersPackage.Orders.service;

import com.ordersPackage.Orders.dto.OrderDto;
import com.ordersPackage.Orders.mappers.OrderMapper;
import com.ordersPackage.Orders.dto.OrderToSaveDto;
import com.ordersPackage.Orders.entity.Order;
import com.ordersPackage.Orders.exception.OrderNotFoundException;
import com.ordersPackage.Orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto saveOrder(OrderToSaveDto orderToSaveDto) {
        Order orderToSave = OrderMapper.INSTANCE.orderToSaveDtoToOrderEntity(orderToSaveDto);
        Order orderSaved = orderRepository.save(orderToSave);
        return OrderMapper.INSTANCE.orderEntityToOrderDto(orderSaved);
    }

    @Override
    public OrderDto findById(Long id) throws OrderNotFoundException {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty())
            throw new OrderNotFoundException("Pedido con ID " + id + " no encontrado");

        return OrderMapper.INSTANCE.orderEntityToOrderDto(order.get());
    }

    @Override
    public List<OrderDto> findByProductIDAndQuantity(Long productID, Integer quantity) throws OrderNotFoundException {
        return null;
    }

    @Override
    public OrderDto updateOrderById(Long id, OrderToSaveDto productToSaveDto) throws OrderNotFoundException {
        Optional<Order> pedidoConsultado = orderRepository.findById(id);

        if (pedidoConsultado.isEmpty())
            throw new OrderNotFoundException("Pedido con ID " + id + " no encontrado");

        Order or = pedidoConsultado.get();

        if (or.getUserID() != null) or.setUserID(or.getUserID());
        if (or.getProductID() != null) or.setProductID(or.getProductID());
        if (or.getQuantity() != null) or.setQuantity(or.getQuantity());
        if (or.getStatus() != null) or.setStatus(or.getStatus());

        Order updatedOrder = orderRepository.save(or);

        return OrderMapper.INSTANCE.orderEntityToOrderDto(updatedOrder);
    }

    @Override
    public OrderDto updatePatchOrderById(Long id, OrderToSaveDto productToSaveDto) throws OrderNotFoundException {
        Optional<Order> orderConsulted = orderRepository.findById(id);

        if (orderConsulted.isEmpty())
            throw new OrderNotFoundException("Pedido con ID " + id + " no encontrado");

        Order or = orderConsulted.get();

        if (or.getQuantity() != null) or.setQuantity(or.getQuantity());
        if (or.getStatus() != null) or.setStatus(or.getStatus());

        Order updatedPatchOrder = orderRepository.save(or);

        return OrderMapper.INSTANCE.orderEntityToOrderDto(updatedPatchOrder);
    }

    @Override
    public void deleteOrderById(Long id) throws OrderNotFoundException {
        Optional<Order> orderToDelete = orderRepository.findById(id);

        if (orderToDelete.isEmpty())
            throw new OrderNotFoundException("Pedido con ID " + id + " no existe");

        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDto> findOrderByStatus(String status) throws OrderNotFoundException {
        List<Order> orderMatch = orderRepository.findByStatus(status);

        if (orderMatch.isEmpty())
            throw new OrderNotFoundException("No se encontraron ordenes con el estado: " + status);

        List<OrderDto> ordersToReturn = new ArrayList<>();

        orderMatch.forEach(pedidos -> {
            OrderDto pedidoMapeado = OrderMapper.INSTANCE.orderEntityToOrderDto(pedidos);
            ordersToReturn.add(pedidoMapeado);
        });

        return ordersToReturn;
    }
}
