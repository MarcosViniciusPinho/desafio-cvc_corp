package com.cvc.corp.desafio.resource.util;

import com.cvc.corp.desafio.entity.Hotel;
import org.junit.Assert;
import org.junit.Test;

public class ObjectUtilTest {

    @Test
    public void deveRetornarVerdadeiroPoisOParametroInformadoFoiValido() {
        Hotel[] hotels = {new Hotel(), new Hotel()};
        Assert.assertTrue(ObjetcUtil.isNotNull(hotels));
    }

    @Test
    public void deveRetornarFalsoPoisOParametroInformadoFoiInvalido() {
        Hotel[] hotels = {};
        Assert.assertFalse(ObjetcUtil.isNotNull(hotels));
    }

    @Test
    public void deveRetornarVerdadeiroPoisOParametroInformadoFoiInvalido() {
        Hotel[] hotels = {};
        Assert.assertTrue(ObjetcUtil.isNull(hotels));
    }

    @Test
    public void deveRetornarFalsoPoisOParametroInformadoFoiValido() {
        Hotel[] hotels = {new Hotel(), new Hotel()};
        Assert.assertFalse(ObjetcUtil.isNull(hotels));
    }

}
