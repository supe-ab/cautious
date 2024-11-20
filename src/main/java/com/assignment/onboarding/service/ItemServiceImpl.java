package com.assignment.onboarding.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.onboarding.bo.ItemBO;
import com.assignment.onboarding.dto.ItemDTO;
import com.assignment.onboarding.mapper.ItemMapper;
import com.assignment.onboarding.vo.ItemVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;
    private final ItemBO itemBO;

    @Transactional
    public ItemVO createItem(ItemVO itemVO) {
        ItemDTO itemDTO = itemMapper.voToDTO(itemVO); // VO -> DTO
        ItemDTO createdDTO = itemBO.createItem(itemDTO); // Call BO
        return itemMapper.dtoToVO(createdDTO); // DTO -> VO
    }

    @Transactional(readOnly = true)
    public List<ItemVO> getAllItems() {
        return itemBO.getAllItems() // Call BO
                .stream()
                .map(itemMapper::dtoToVO) // DTO -> VO
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public void healthCheck() throws Exception {
    	itemBO.healthCheck();
    }
}
