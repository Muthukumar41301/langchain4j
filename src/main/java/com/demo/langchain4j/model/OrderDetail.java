package com.demo.langchain4j.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", unique = true, nullable = false)
    private String orderId;

    private String customerName;

    private String productName;

    private String status;

    private String currentLocation;

    private LocalDate expectedDelivery;

    private BigDecimal totalAmount;

    private String paymentStatus;
}
