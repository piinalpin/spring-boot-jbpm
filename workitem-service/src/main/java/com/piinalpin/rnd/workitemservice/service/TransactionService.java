package com.piinalpin.rnd.workitemservice.service;

import com.piinalpin.rnd.workitemservice.domain.dto.TransactionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
public class TransactionService {

    private final RestTemplate restTemplate;

    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${transaction-service.api.save-transaction}")
    private String saveTransactionUrl;

    public TransactionDto save(BigDecimal amount, String status) {
        log.info("Request save transaction through rest");
        return restTemplate.postForObject(saveTransactionUrl, TransactionDto.builder()
                        .status(status)
                        .transactionAmount(amount)
                        .transactionDate(LocalDateTime.now().toString())
                .build(), TransactionDto.class);
    }

}
