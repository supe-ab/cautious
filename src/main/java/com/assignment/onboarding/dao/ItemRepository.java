package com.assignment.onboarding.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.onboarding.entity.Item;
import com.assignment.onboarding.eo.ItemEO;

public interface ItemRepository extends JpaRepository<Item, Long> {}

