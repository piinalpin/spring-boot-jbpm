package com.piinalpin.rnd.financingservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class FinancingController {

    @PostMapping(value = "/save")
    public ResponseEntity<FinancingDto> save(@RequestBody FinancingDto dto) {
        log.info("REST save financing {}", dto);
        dto.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(dto);
    }

}