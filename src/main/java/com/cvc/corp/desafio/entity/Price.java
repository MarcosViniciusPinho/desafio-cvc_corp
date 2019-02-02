package com.cvc.corp.desafio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class Price {

    private BigDecimal adult;
    private BigDecimal child;

}
