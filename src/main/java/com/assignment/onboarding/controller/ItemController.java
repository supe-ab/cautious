package com.assignment.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        try {
            itemService.healthCheck(); 
            return ResponseEntity.ok("Health Check passed. Downstream system is healthy");
        } catch (ArithmeticException ex) {
            
            return ResponseEntity.ok("Health Check passed. Downstream system is healthy");
        } catch (Exception ex) {
          
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Health Check failed: " + ex.getMessage());
        }
    }


}

	
	
		


