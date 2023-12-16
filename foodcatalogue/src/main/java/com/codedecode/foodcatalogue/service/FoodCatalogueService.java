package com.codedecode.foodcatalogue.service;

import com.codedecode.foodcatalogue.dto.FoodCataloguePage;
import com.codedecode.foodcatalogue.dto.FoodItemDTO;

public interface FoodCatalogueService {


    FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO);

    FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId);
}
