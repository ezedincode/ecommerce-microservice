package com.ezedin.inventory_service.service;

import com.ezedin.inventory_service.dto.InventoryResponse;
import com.ezedin.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock (List<String> skuCode){
       return inventoryRepository.findBySkuCodeIn(skuCode).stream()
               .map(inventory ->
                   InventoryResponse.builder()
                           .skuCode(inventory.getSkuCode())
                           .isInStock(inventory.getQuantity() > 0)
                           .build()
               ).toList();
    }
}
