package com.wasp.avt.basedomain.mapper;

import com.wasp.avt.basedomain.dto.OrderDto;
import com.wasp.avt.basedomain.entity.Order;

public class OrderMapper {
    public static OrderDto modelToDto(Order model) {
        return model == null ? null : new OrderDto(
                model.getOrderId(),
                model.getName(),
                model.getQty(),
                model.getPrice());
    }

    public static Order dtoToModel(OrderDto dto) {
        return dto == null ? null : new Order(
                dto.orderId(),
                dto.name(),
                dto.qty(),
                dto.price());
    }
}
