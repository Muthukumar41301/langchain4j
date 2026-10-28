package com.demo.langchain4j.repository;

import com.demo.langchain4j.model.RefundPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefundPolicyRepository extends JpaRepository<RefundPolicy, Long> {
    Optional<RefundPolicy> findByOrderStatus(String orderStatus);
}
