package com.codedecode.foodcatalogue.service.impl;

import com.codedecode.foodcatalogue.dto.FoodCataloguePage;
import com.codedecode.foodcatalogue.dto.FoodItemDTO;
import com.codedecode.foodcatalogue.dto.Restaurant;
import com.codedecode.foodcatalogue.entity.FoodItem;
import com.codedecode.foodcatalogue.mapper.FoodItemMapper;
import com.codedecode.foodcatalogue.repository.FoodItemRepository;
import com.codedecode.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueServiceImpl implements FoodCatalogueService {

    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO);
        FoodItem savedFoodItem = foodItemRepository.save(foodItem);
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItem);
    }

    @Override
    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {

        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        FoodCataloguePage foodCataloguePage = createFoodCataloguePage(foodItemList, restaurant);
        return foodCataloguePage;
    }

    public FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }

    public Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId){
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }
}

