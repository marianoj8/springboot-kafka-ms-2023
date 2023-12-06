package com.wasp.avt.orderservice.controller;

import com.wasp.avt.basedomain.dto.OrderDto;
import com.wasp.avt.basedomain.mapper.OrderMapper;
import com.wasp.avt.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto dto) {
        return new ResponseEntity<>(service.create(OrderMapper.dtoToModel(dto)), CREATED);
    }
}
