package com.ordersPackage.Orders.mappers;

import com.ordersPackage.Orders.dto.OrderDto;
import com.ordersPackage.Orders.dto.OrderToSaveDto;
import com.ordersPackage.Orders.entity.Order;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "userID", target = "userID"),
            @Mapping(source = "productID", target = "productID"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "status", target = "status")
    })
    OrderDto orderEntityToOrderDto(Order order);

    @InheritInverseConfiguration
    Order orderDtoToOrderEntity(OrderDto orderDto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "userID", target = "userID"),
            @Mapping(source = "productID", target = "productID"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "status", target = "status")
    })
    OrderToSaveDto orderEntityToOrderToSaveDto(Order order);

    @InheritInverseConfiguration
    Order orderToSaveDtoToOrderEntity(OrderToSaveDto orderToSaveDto);
}
