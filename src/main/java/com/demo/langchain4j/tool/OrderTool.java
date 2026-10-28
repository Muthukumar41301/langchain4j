package com.demo.langchain4j.tool;

import com.demo.langchain4j.model.OrderDetail;
import com.demo.langchain4j.service.OrderService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

@Service
public class OrderTool {

    private final OrderService orderService;

    public OrderTool(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderDetail getOrderDetail(String orderId) {
        return orderService.getOrderDetail(orderId);
    }

    @Tool("Cancel an order")
    public OrderDetail cancelOrder(String orderId) {
        return orderService.cancelOrder(orderId);
    }
}
