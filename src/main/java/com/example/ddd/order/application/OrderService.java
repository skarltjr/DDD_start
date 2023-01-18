package com.example.ddd.order.application;

import com.example.ddd.catalog.application.ProductService;
import com.example.ddd.catalog.domain.product.Product;
import com.example.ddd.order.application.request.Request;
import com.example.ddd.order.application.response.OrderLineDetail;
import com.example.ddd.order.application.response.Response;
import com.example.ddd.order.domain.*;
import com.example.ddd.order.domain.domainService.DiscountCalculationService;
import com.example.ddd.order.domain.domainService.OrdererService;
import com.example.ddd.order.domain.vo.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrdererService ordererService;
    private final ProductService productService;
    private final DiscountCalculationService discountCalculationService;

    @Transactional
    public Response.CreateOrder placeOrder(Request.createOrder req) {
        // 다른 애그리거트의 도움이 필요할떈 어떻게 할것인가.
        // memberId로 멤버 애그리거트에 접근하여 member를 가져와야하는경우
        // 도메인 서비스를 활용한다
        // 다른 애그리거트 도움을 받는 구현체는 인프라에 위치한다.
        Orderer orderer = ordererService.createOrderer(req.getMemberId());

        List<OrderLine> orderLines = new ArrayList<>();
        req.getProducts().forEach(orderProduct -> {
            Product product = productService.getProduct(orderProduct.getProductId());
            orderLines.add(new OrderLine(product.getId(), orderProduct.getQuantity(), product.getPrice()));
        });

        Order order = new Order(orderer, req.getShippingInfo(), OrderState.PAYMENT_WAITING, orderLines);
        order.calculateAmounts(discountCalculationService,orderer.getGrade());
        Order saved = orderRepository.save(order);

        return createOrderResponse(saved);
    }

    private Response.CreateOrder createOrderResponse(Order order) {
        return Response.CreateOrder.builder()
                .orderId(order.getId())
                .orderer(order.getOrderer())
                .shippingInfo(order.getShippingInfo())
                .state(order.getState())
                .totalAmounts(order.getTotalAmounts().getValue())
                .orderLineDetails(createOrderLineDetail(order.getOrderLines()))
                .paymentAmounts(order.getPaymentAmounts().getValue())
                .build();
    }

    private List<OrderLineDetail> createOrderLineDetail(List<OrderLine> orderLines) {
        return orderLines.stream().map(orderLine -> new OrderLineDetail(orderLine)).collect(Collectors.toList());
    }
}
