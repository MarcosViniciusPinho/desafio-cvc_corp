package com.cvc.corp.desafio.resource.util;

import org.junit.Assert;
import org.junit.Test;

public class CallUtilTest {

    @Test
    public void deveRetornarAUriCorrespondenteAoServicoDeListarHoteisPorCodigoDaCidade() {
        String uriEsperada = "https://cvcbackendhotel.herokuapp.com/hotels/avail/{cityCode}";
        Assert.assertEquals(uriEsperada, CallUtil.executeHotelsAvail("https://cvcbackendhotel.herokuapp.com/"));
    }

    @Test
    public void deveRetornarAUriCorrespondenteAoServicoDeBuscaDeHotelPeloCodigo() {
        String uriEsperada = "https://cvcbackendhotel.herokuapp.com/hotels/{id}";
        Assert.assertEquals(uriEsperada, CallUtil.executeHotels("https://cvcbackendhotel.herokuapp.com/"));
    }
}
