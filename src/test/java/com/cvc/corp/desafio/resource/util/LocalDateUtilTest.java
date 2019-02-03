package com.cvc.corp.desafio.resource.util;

import org.junit.Assert;
import org.junit.Test;

import java.time.format.DateTimeParseException;

public class LocalDateUtilTest {

    @Test
    public void deveCalcularOPeriodoDeDias() {
        String dataEntrada = "2018-05-20";
        String dataSaida = "2018-05-25";

        Assert.assertEquals(Long.valueOf(5), LocalDateUtil.getTotalDoPeridoDeDias(dataEntrada, dataSaida));
    }

    @Test(expected = DateTimeParseException.class)
    public void deveDarErroAoTentarPassarDataNoPadraoBrasileiro() {
        String dataEntrada = "20/05/2018";
        String dataSaida = "25/05/2018";

        LocalDateUtil.getTotalDoPeridoDeDias(dataEntrada, dataSaida);
    }

}
