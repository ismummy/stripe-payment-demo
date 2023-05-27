package com.mainstack.stripepaymentdemo.controller;

import com.mainstack.stripepaymentdemo.dto.CreatePaymentDto;
import com.mainstack.stripepaymentdemo.dto.CreatePaymentResponseDto;
import com.mainstack.stripepaymentdemo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponseDto createPaymentIntent(@RequestBody CreatePaymentDto createPaymentDto) {
        return paymentService.createPaymentIntent(createPaymentDto);
    }

    @PostMapping("/strip/event")
    public String handleStripeEvent(@RequestHeader("Stripe-Signature") String sigHeader, @RequestBody String payload) {
        return paymentService.handleStripeEvent(sigHeader, payload);
    }

}
