package com.piinalpin.rnd.transactionservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class TransactionController {

    @PostMapping(value = "/save")
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto) {
        log.info("REST save transaction = {}", dto);
        dto.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/history")
    public ResponseEntity<List<TransactionDto>> getAllTransaction() {
        log.info("REST get all transaction history");
        List<TransactionDto> transactions = new ArrayList<>(List.of(
                TransactionDto.builder()
                        .id(UUID.randomUUID().toString())
                        .status("SUCCESS")
                        .transactionDate(LocalDateTime.now().toString())
                        .transactionAmount(new BigDecimal("36700000"))
                        .build(),
                TransactionDto.builder()
                        .id(UUID.randomUUID().toString())
                        .status("SUCCESS")
                        .transactionDate(LocalDateTime.now().toString())
                        .transactionAmount(new BigDecimal("21610000"))
                        .build()
        ));
        return ResponseEntity.ok(transactions);
    }

}
