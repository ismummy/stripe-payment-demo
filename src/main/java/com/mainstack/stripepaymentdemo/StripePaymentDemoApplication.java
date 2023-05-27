package com.mainstack.stripepaymentdemo;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StripePaymentDemoApplication {

    @Value("${stripe.api.key}")
    private String StripeApiKey;

    @PostConstruct
    public void setup(){
        Stripe.apiKey = StripeApiKey;
    }

    public static void main(String[] args) {
        SpringApplication.run(StripePaymentDemoApplication.class, args);
    }

}
