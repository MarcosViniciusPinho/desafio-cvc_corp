package com.cvc.corp.desafio.entity;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class RoomTest {

    @Test
    public void deveCalcularAComissao() {
        Price price = new Price();
        price.setAdult(BigDecimal.valueOf(100));
        price.setChild(BigDecimal.valueOf(50));

        Room room = new Room();
        room.setPrice(price);
        BigDecimal total = room.calcularComissao(5L, 2L, 1L);
        Assert.assertEquals(BigDecimal.valueOf(1785L), total);
    }

}
