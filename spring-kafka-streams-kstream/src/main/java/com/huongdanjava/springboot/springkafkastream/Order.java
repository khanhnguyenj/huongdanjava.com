package com.huongdanjava.springboot.springkafkastream;

public record Order(Long id, String customerId, Double amount, String status) {}
