package com.assignment.onboarding.mapper;

import org.springframework.web.bind.annotation.Mapping;

import com.assignment.onboarding.bo.ItemBO;
import com.assignment.onboarding.entity.Item;
import com.assignment.onboarding.eo.ItemEO;
import com.assignment.onboarding.vo.ItemVO;



@Mapper(componentModel = "spring")
public interface ItemMapper {

    // VO <-> BO mappings
    ItemBO voToBO(ItemVO vo);
    ItemVO boToVO(ItemBO bo);

    // BO <-> EO mappings
    ItemEO boToEO(ItemBO bo);
    ItemBO eoToBO(ItemEO eo);

    // EO <-> Entity mappings
    ItemEO entityToEO(Item entity);
    
    Item eoToEntity(ItemEO eo);
}