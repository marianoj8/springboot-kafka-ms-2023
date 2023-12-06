package com.wasp.avt.orderservice.service;

import com.wasp.avt.basedomain.dto.OrderDto;
import com.wasp.avt.basedomain.entity.Order;
import com.wasp.avt.basedomain.event.OrderEvent;
import com.wasp.avt.basedomain.mapper.OrderMapper;
import com.wasp.avt.orderservice.kafka.OrderProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderProducer orderProducer;

    public OrderService(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    public OrderDto create(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PADDING");
        orderEvent.setMessage("Order status is in pending state");

        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return OrderMapper.modelToDto(order);
    }
}
