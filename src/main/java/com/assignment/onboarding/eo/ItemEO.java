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
        Item entity = itemMapper.dtoToEntity(itemDTO); 
        Item savedEntity = itemRepository.save(entity); 
        return itemMapper.entityToDTO(savedEntity); 
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::entityToDTO) 
                .collect(Collectors.toList());
    }

    public void healthCheck() throws Exception {
        try {
            
            itemRepository.findById(0L);  

           
            throw new ArithmeticException("HealthCheck passed: Downstream system is healthy");

        } catch (ArithmeticException e) {
            
            throw new ArithmeticException(e.getMessage()); 
        } catch (Exception e) {
            
            throw new Exception("HealthCheck failed: " + e.getMessage());
        }
    }



		
		
		
		
	}

