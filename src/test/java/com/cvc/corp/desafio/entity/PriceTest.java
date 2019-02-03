package com.cvc.corp.desafio.entity;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PriceTest {

    @Test
    public void deveCalcularOPrecoPelaQuantidadeDeDiasPorAdulto() {
        Price price = new Price();
        price.setAdult(BigDecimal.valueOf(100));
        BigDecimal total = price.calcularValorAdulto(5L, 2L);
        Assert.assertEquals(BigDecimal.valueOf(1000L), total);
    }

    @Test
    public void deveCalcularOPrecoPelaQuantidadeDeDiasPorCrianca() {
        Price price = new Price();
        price.setChild(BigDecimal.valueOf(50));
        BigDecimal total = price.calcularValorCrianca(5L, 1L);
        Assert.assertEquals(BigDecimal.valueOf(250L), total);
    }

    @Test
    public void naoDeveCalcularOPrecoPelaQuantidadeDeDiasPorAdulto() {
        Price price = new Price();
        BigDecimal total = price.calcularValorAdulto(5L, 1L);
        Assert.assertNull(total);
    }

    @Test
    public void naoDeveCalcularOPrecoPelaQuantidadeDeDiasPorCrianca() {
        Price price = new Price();
        BigDecimal total = price.calcularValorCrianca(5L, 1L);
        Assert.assertNull(total);
    }

}
