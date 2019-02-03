package com.cvc.corp.desafio.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Price price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalPrice;

    private PriceDetail priceDetail;

    public BigDecimal calcularComissao(Long quantidadeDeDias, Long totalDeAdultos, Long totalDeCriancas) {
        if(this.price == null) {
            return null;
        }

        BigDecimal valorPorAdulto = this.price.calcularValorCrianca(quantidadeDeDias, totalDeCriancas);
        BigDecimal valorPorCrianca = this.price.calcularValorAdulto(quantidadeDeDias, totalDeAdultos);

        this.priceDetail = new PriceDetail(valorPorAdulto, valorPorCrianca);
        this.price = null;

        BigDecimal valorComissaoAdulto = this.priceDetail.getPricePerDayAdult().divide(
                BigDecimal.valueOf(0.7), BigDecimal.ROUND_FLOOR);
        BigDecimal valorComissaoCrianca = this.priceDetail.getPricePerDayChild().divide(
                BigDecimal.valueOf(0.7), BigDecimal.ROUND_FLOOR);

        return valorComissaoAdulto.add(valorComissaoCrianca);
    }

}
