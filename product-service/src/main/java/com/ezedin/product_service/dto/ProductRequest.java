package com.ezedin.product_service.dto;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductRequest(
        String id,
        String name,
        String description,
        String skuCode,
        BigDecimal price
                ) { }

