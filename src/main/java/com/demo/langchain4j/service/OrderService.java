package com.demo.langchain4j.service;

import com.demo.langchain4j.model.OrderDetail;
import com.demo.langchain4j.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderDetail getOrderDetail(String orderId){
        return orderDetailRepository.findByOrderId(orderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found: " + orderId
                        )
                );
    }

    public OrderDetail cancelOrder(String orderId) {
        OrderDetail order = orderDetailRepository.findByOrderId(orderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found: " + orderId
                        )
                );
        if (order.getStatus().equalsIgnoreCase("Shipped")) {
            throw new RuntimeException("Cannot cancel an order that has already been shipped.");
        }
        order.setStatus("CANCELLED");
        order.setExpectedDelivery(null);
        return orderDetailRepository.save(order);
    }
}
