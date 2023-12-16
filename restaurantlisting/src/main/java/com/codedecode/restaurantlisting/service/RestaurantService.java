package com.codedecode.restaurantlisting.service;

import com.codedecode.restaurantlisting.dto.RestaurantDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDTO> findAllRestaurants();

    RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO);

    ResponseEntity<RestaurantDTO> findRestaurantById(int restId);
}
