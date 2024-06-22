package com.jtsp.paymentservice.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "EMAIL-SERVICE", url = "http://localhost:8082")
public interface EmailService {
    @GetMapping("/email")
    public ResponseEntity<String> email();
}
