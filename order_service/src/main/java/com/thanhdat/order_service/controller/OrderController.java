package com.thanhdat.order_service.controller;

import com.thanhdat.order_service.UserClient;
import com.thanhdat.order_service.dto.OrderResponse;
import com.thanhdat.order_service.dto.UserDto;
import com.thanhdat.order_service.entity.Order;
import com.thanhdat.order_service.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    @PostMapping
    Order creteOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    OrderResponse getOrderById(@PathVariable("id") Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();

        UserDto user = userClient.getUserById(order.getUserId());

        return new OrderResponse(order.getId(), order.getProduct(), order.getPrice(), user);
    }
}
