package com.codedecode.foodcatalogue.dto;

import com.codedecode.foodcatalogue.entity.FoodItem;
import lombok.Data;

import java.util.List;

@Data
public class FoodCataloguePage {

    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
}
