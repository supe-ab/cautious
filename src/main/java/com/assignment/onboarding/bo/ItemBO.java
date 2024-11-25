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
       
        return itemEO.createItem(itemDTO); 
    }

    public List<ItemDTO> getAllItems() {
        
        return itemEO.getAllItems(); 
    }

	public void healthCheck() throws Exception {
		itemEO.healthCheck();
		
		
	}
}
