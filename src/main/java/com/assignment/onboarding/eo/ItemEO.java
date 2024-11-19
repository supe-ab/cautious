package com.assignment.onboarding.eo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.assignment.onboarding.dao.ItemRepository;
import com.assignment.onboarding.dto.ItemDTO;
import com.assignment.onboarding.entity.Item;
import com.assignment.onboarding.mapper.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemEO {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemDTO createItem(ItemDTO itemDTO) {
        Item entity = itemMapper.dtoToEntity(itemDTO); // DTO -> Entity
        Item savedEntity = itemRepository.save(entity); // Save to DB
        return itemMapper.entityToDTO(savedEntity); // Entity -> DTO
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::entityToDTO) // Entity -> DTO
                .collect(Collectors.toList());
    }

	public void healthCheck() {
		try {
			itemRepository.findById(0L);
		}catch(Exception e) {
			if(e instanceof DataAccessException ) {
				throw new IllegalStateException("Downstream system is unhealthy");
			}
			throw e;
		}
	}
		
		
		
		
	}

