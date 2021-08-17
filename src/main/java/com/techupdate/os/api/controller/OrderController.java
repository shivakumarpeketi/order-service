package com.techupdate.os.api.controller;

import com.techupdate.os.api.common.Order;
import com.techupdate.os.api.common.TransactionRequest;
import com.techupdate.os.api.common.TransactionResponse;
import com.techupdate.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return orderService.save(request);
    }

    @GetMapping("/orders/{orderId}/payment/{paymentAmount}")
    public Order bookOrder(@PathVariable int orderId, @PathVariable int paymentAmount) throws Exception {
        System.out.println("#############");
        System.out.println("Order Id: "+ orderId + " Payment: "+ paymentAmount);
        com.techupdate.os.api.entity.Order order = orderService.getOrder(orderId);
        return new Order(order.getId(), order.getName(), order.getQty(), order.getPrice());
    }
}
