package com.piinalpin.rnd.financingservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancingDto {

    private String id;
    private String type;
    private BigDecimal amount;

}
