package com.assignment.onboarding.mapper;

import org.mapstruct.Mapper;
import com.assignment.onboarding.dto.ItemDTO;
import com.assignment.onboarding.entity.Item;
import com.assignment.onboarding.vo.ItemVO;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDTO voToDTO(ItemVO vo);
    ItemVO dtoToVO(ItemDTO dto);

    ItemDTO entityToDTO(Item entity);
    Item dtoToEntity(ItemDTO dto);
}
