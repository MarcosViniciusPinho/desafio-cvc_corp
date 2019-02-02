package com.cvc.corp.desafio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class Room {

    private Long roomID;
    private String categoryName;
    private Price price;

    public BigDecimal calcularComissao(Long quantidadeDeDias, Long totalDeAdultos, Long totalDeCriancas) {
        if(this.price == null) {
            return null;
        }

        BigDecimal valorPorAdulto = this.price.calcularValorCrianca(quantidadeDeDias, totalDeCriancas);
        BigDecimal valorPorCrianca = this.price.calcularValorAdulto(quantidadeDeDias, totalDeAdultos);

        BigDecimal valorComissaoAdulto = valorPorAdulto.divide(BigDecimal.valueOf(0.7), BigDecimal.ROUND_FLOOR);
        BigDecimal valorComissaoCrianca = valorPorCrianca.divide(BigDecimal.valueOf(0.7), BigDecimal.ROUND_FLOOR);

        return valorComissaoAdulto.add(valorComissaoCrianca);
    }

}
