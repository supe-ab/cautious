package com.assignment.onboarding.service;



import com.assignment.onboarding.bo.ItemBO;
import com.assignment.onboarding.dao.ItemRepository;
import com.assignment.onboarding.entity.Item;
import com.assignment.onboarding.eo.ItemEO;
import com.assignment.onboarding.mapper.ItemMapper;
import com.assignment.onboarding.service.ItemService;
import com.assignment.onboarding.vo.ItemVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
    
    private final ItemRepository itemRepository;  
    private final ItemMapper itemMapper;          
    

    @Override
    public ItemVO createItem(ItemVO itemVO) {
        logger.info("Creating item: {}", itemVO.getName());
        
        // VO to BO
        ItemBO itemBO = itemMapper.voToBO(itemVO);
        
        // BO to EO (prepare for persistence)
        ItemEO item = itemMapper.boToEO(itemBO);
        
        // Save to the database (EO -> Entity)
        Item savedItem = itemRepository.save(item);
        
        // Convert saved entity to BO (Entity -> EO -> BO)
        ItemBO savedItemBO = itemMapper.eoToBO(itemMapper.entityToEO(savedItem));
        
        // Convert BO back to VO to send as response
        ItemVO savedItemVO = itemMapper.boToVO(savedItemBO);
        
        logger.info("Item created with ID: {}", savedItemVO.getId());
        return savedItemVO;
    }

    

    // Method to retrieve all items
    @Override
    public List<ItemVO> getAllItems() {
        logger.info("Retrieving all items.");
        
        // Retrieve all items from the database, convert from Entity to BO
        List<ItemVO> items = itemRepository.findAll().stream()
            .map(item -> itemMapper.eoToBO(itemMapper.entityToEO(item)))
            .map(itemMapper::boToVO)  // Convert BO to VO
            .collect(Collectors.toList());
        
        logger.info("Total items retrieved: {}", items.size());
        return items;
    }
}
