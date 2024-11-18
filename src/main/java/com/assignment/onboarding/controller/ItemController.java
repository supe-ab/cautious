package com.assignment.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.onboarding.service.ItemService;
import com.assignment.onboarding.vo.ItemVO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	@Autowired
	private  ItemService itemService;
	
	@PostMapping
	public ResponseEntity<ItemVO> createItem(@Valid @RequestBody ItemVO itemVO){
		return ResponseEntity.ok(itemService.createItem(itemVO));
	}
	
	@GetMapping
	public ResponseEntity<List<ItemVO>> getAllItems(){
		return ResponseEntity.ok(itemService.getAllItems());
	}
}

	
	
		


