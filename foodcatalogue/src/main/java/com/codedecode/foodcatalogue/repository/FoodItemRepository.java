package com.codedecode.foodcatalogue.repository;

import com.codedecode.foodcatalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem,Integer> {
    List<FoodItem> findByRestaurantId(Integer restaurantId);
}
