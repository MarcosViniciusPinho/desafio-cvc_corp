package com.cvc.corp.desafio.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetail {

    private BigDecimal pricePerDayAdult;
    private BigDecimal pricePerDayChild;

}
