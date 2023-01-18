package com.example.ddd.order.presentation;


import com.example.ddd.order.application.OrderService;
import com.example.ddd.order.application.request.Request;
import com.example.ddd.order.application.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Response.CreateOrder order(@RequestBody @Valid Request.createOrder req){
        Response.CreateOrder res = orderService.placeOrder(req);
        return res;
    }
}
