package com.assignment.onboarding.service;

import java.util.List;

import com.assignment.onboarding.bo.ItemBO;
import com.assignment.onboarding.vo.ItemVO;

import jakarta.validation.Valid;

public interface ItemService {

	ItemVO createItem(ItemVO itemVO);      
   
    List<ItemVO> getAllItems();

	void healthCheck();             

}
