package com.demo.langchain4j.tool;

import com.demo.langchain4j.service.RefundService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class RefundTool {

    private final RefundService refundService;

    public RefundTool(RefundService refundService) {
        this.refundService = refundService;
    }

    @Tool("Check whether an order is eligible for a refund based on order status")
    public String checkRefundEligibility(String orderStatus) {
        return refundService.checkEligibility(orderStatus).toString();
    }
}
