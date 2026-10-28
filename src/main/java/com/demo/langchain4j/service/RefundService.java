package com.demo.langchain4j.service;

import com.demo.langchain4j.model.RefundPolicy;
import com.demo.langchain4j.repository.RefundPolicyRepository;
import org.springframework.stereotype.Service;

@Service
public class RefundService {

    private final RefundPolicyRepository repository;

    public RefundService(RefundPolicyRepository repository) {
        this.repository = repository;
    }

    public RefundPolicy checkEligibility(String orderStatus) {
        return repository.findByOrderStatus(orderStatus)
                .orElseThrow(() -> new RuntimeException("Refund policy not found for: " + orderStatus));
    }
}
