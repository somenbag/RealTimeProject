package com.codedecode.order.service;

import com.codedecode.order.dto.OrderDTO;
import com.codedecode.order.dto.OrderDTOFromFE;

public interface OrderService {
    OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails);
}
