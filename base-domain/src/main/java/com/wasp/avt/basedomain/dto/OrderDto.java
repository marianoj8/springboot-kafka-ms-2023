package com.wasp.avt.basedomain.dto;

public record OrderDto(
        String orderId,
        String name,
        int qty,
        double price) {
}
