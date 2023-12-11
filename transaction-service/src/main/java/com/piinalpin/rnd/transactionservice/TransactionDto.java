package com.piinalpin.rnd.transactionservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private String id;
    private String transactionDate;
    private BigDecimal transactionAmount;
    private String status;

}
