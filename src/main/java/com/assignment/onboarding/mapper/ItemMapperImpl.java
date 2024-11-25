package com.assignment.onboarding.mapper;

import com.assignment.onboarding.dto.ItemDTO;
import com.assignment.onboarding.entity.Item;
import com.assignment.onboarding.vo.ItemVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-18T18:54:31+0530",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDTO voToDTO(ItemVO vo) {
        if ( vo == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId( vo.getId() );
        itemDTO.setName( vo.getName() );
        itemDTO.setQuantity( vo.getQuantity() );

        return itemDTO;
    }

    @Override
    public ItemVO dtoToVO(ItemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ItemVO itemVO = new ItemVO();

        itemVO.setId( dto.getId() );
        itemVO.setName( dto.getName() );
        itemVO.setQuantity( dto.getQuantity() );

        return itemVO;
    }

    @Override
    public ItemDTO entityToDTO(Item entity) {
        if ( entity == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId( entity.getId() );
        itemDTO.setName( entity.getName() );
        itemDTO.setQuantity( entity.getQuantity() );

        return itemDTO;
    }

    @Override
    public Item dtoToEntity(ItemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( dto.getId() );
        item.setName( dto.getName() );
        item.setQuantity( dto.getQuantity() );

        return item;
    }
}
