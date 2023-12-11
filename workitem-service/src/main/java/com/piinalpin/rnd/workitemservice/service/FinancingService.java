package com.piinalpin.rnd.workitemservice.service;

import com.piinalpin.rnd.workitemservice.domain.dto.FinancingDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class FinancingService {

    private final RestTemplate restTemplate;

    public FinancingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${financing-service.api.save-financing}")
    private String saveFinancingUrl;

    public FinancingDto save(FinancingDto dto) {
        log.info("Save financing through rest api {}", dto);
        return restTemplate.postForObject(saveFinancingUrl, dto, FinancingDto.class);
    }

}
