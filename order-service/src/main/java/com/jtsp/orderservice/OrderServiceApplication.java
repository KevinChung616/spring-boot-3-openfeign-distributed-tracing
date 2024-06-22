package com.jtsp.orderservice;

import com.jtsp.orderservice.remote.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@EnableFeignClients
public class OrderServiceApplication {

    @Autowired
    private PaymentService paymentService;
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @GetMapping("/orders")
    public ResponseEntity<String> order() {
        log.info("create a new order");
        paymentService.payment();
        return ResponseEntity.ok("create new order");
    }
}
