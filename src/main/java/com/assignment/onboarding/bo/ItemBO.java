package com.assignment.onboarding.bo;


import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.onboarding.dto.ItemDTO;
import com.assignment.onboarding.eo.ItemEO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemBO {
    private final ItemEO itemEO;

    public ItemDTO createItem(ItemDTO itemDTO) {
        // Add any business rules or logic here
        return itemEO.createItem(itemDTO); // Pass to EO
    }

    public List<ItemDTO> getAllItems() {
        // Any additional processing on retrieved items can go here
        return itemEO.getAllItems(); // Call EO
    }

	public void healthCheck() {
		itemEO.healthCheck();
		
		
	}
}
