package com.jtsp.paymentservice;

import com.jtsp.paymentservice.remote.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@Slf4j
@RestController
public class PaymentServiceApplication {

    @Autowired
    private EmailService emailService;
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

    @GetMapping("/payments")
    public ResponseEntity<String> payment() {
        log.info("get a new payment");
        emailService.email();
        return ResponseEntity.ok("payment success");
    }
}
