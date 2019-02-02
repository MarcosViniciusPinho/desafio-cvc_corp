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

    public BigDecimal calcularValorAdulto(Long quantidadeDeDias, Long totalDeAdultos) {
        if(this.adult == null) {
            return null;
        }
        BigDecimal valorPorAdulto = adult.multiply(BigDecimal.valueOf(totalDeAdultos));
        return valorPorAdulto.multiply(BigDecimal.valueOf(quantidadeDeDias));
    }

    public BigDecimal calcularValorCrianca(Long quantidadeDeDias, Long totalDeCriancas) {
        if(this.child == null) {
            return null;
        }
        BigDecimal valorPorCrianca = child.multiply(BigDecimal.valueOf(totalDeCriancas));
        return valorPorCrianca.multiply(BigDecimal.valueOf(quantidadeDeDias));
    }
}
