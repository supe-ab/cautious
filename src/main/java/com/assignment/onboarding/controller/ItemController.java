package com.assignment.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.onboarding.dao.ItemRepository;
import com.assignment.onboarding.mapper.ItemMapper;
import com.assignment.onboarding.service.ItemService;
import com.assignment.onboarding.vo.ItemVO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemVO> createItem(@Valid @RequestBody ItemVO itemVO) {
        return ResponseEntity.ok(itemService.createItem(itemVO));
    }

    @GetMapping
    public ResponseEntity<List<ItemVO>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
    	try {
    		itemService.healthCheck();
    		return ResponseEntity.ok("Health check passed. Downstream systems are working fine.");
    		
    	}
    	catch(Exception e) {
    		return ResponseEntity.status(500).body("Health check failed: "+e.getMessage());
    	}
    }
}

	
	
		


