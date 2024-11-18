package com.assignment.onboarding.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.onboarding.dao.ItemRepository;
import com.assignment.onboarding.dto.ItemDTO;
import com.assignment.onboarding.entity.Item;
import com.assignment.onboarding.mapper.ItemMapper;
import com.assignment.onboarding.vo.ItemVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Transactional
    public ItemVO createItem(ItemVO itemVO) {
        ItemDTO itemDTO = itemMapper.voToDTO(itemVO);
        Item item = itemMapper.dtoToEntity(itemDTO);
        Item savedItem = itemRepository.save(item);
        ItemDTO savedDTO = itemMapper.entityToDTO(savedItem);
        return itemMapper.dtoToVO(savedDTO);
    }

    @Transactional(readOnly = true)
    public List<ItemVO> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::entityToDTO)
                .map(itemMapper::dtoToVO)
                .collect(Collectors.toList());
    }
}
