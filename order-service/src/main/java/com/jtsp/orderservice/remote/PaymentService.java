package com.jtsp.orderservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PAYMENT-SERVICE", url = "http://localhost:8081")
public interface PaymentService {
    @GetMapping("/payments")
    public ResponseEntity<String> payment();
}
